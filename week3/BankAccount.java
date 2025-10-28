// 1. Write a program to create a Bank Account management system
// without using built-in collection classes
// Hint =>
// a. Create a BankAccount class with private instance variables: accountNumber
// (String), accountHolderName (String), balance (double), and a static variable
// totalAccounts (int)
// b. Create a constructor that takes account holder name and initial deposit,
// automatically generates account number using a static counter
// c. Create instance methods: deposit(double amount), withdraw(double amount),
// checkBalance() with proper validation for negative amounts and insufficient funds
// d. Create static methods: getTotalAccounts(), generateAccountNumber() that
// returns a unique account number like "ACC001", "ACC002"
// e. Create a method displayAccountInfo() to show all account details in a formatted
// manner
// f. In the main method, create an array of BankAccount objects, demonstrate
// creating multiple accounts, performing transactions, and showing the difference
// between static and instance variables

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int totalAccounts = 0;

    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }


    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount("John Doe", 5000);
        accounts[1] = new BankAccount("Jane Smith", 3000);
        accounts[2] = new BankAccount("Mark Johnson", 7000);

        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }

        // Perform some transactions
        accounts[0].deposit(1500);     
        accounts[1].withdraw(2000);     
        accounts[2].withdraw(8000);     

        // Display account info after transactions
        System.out.println("\nAfter Transactions:");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }

        // Show total number of accounts
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
