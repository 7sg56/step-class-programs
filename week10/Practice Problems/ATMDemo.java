// File: BankAccount.java
class BankAccount {
    private String accNumber;
    private int pin;
    private double balance;
    
    public BankAccount(String accNumber, int pin, double balance) {
        this.accNumber = accNumber;
        this.pin = pin;
        this.balance = balance;
    }
    
    public boolean validatePin(int enteredPin) { 
        return this.pin == enteredPin; 
    }
    
    public void debit(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf(" [ACCOUNT] Debit successful. Remaining Balance: $%.2f%n", balance);
        } else {
            System.out.println(" [ACCOUNT] Debit failed. Insufficient funds.");
        }
    }
    
    public void showDetails() { 
        System.out.println("Account: " + accNumber + ", Balance: $" + balance); 
    }
}

// File: ATM.java
class ATM {
    private BankAccount linkedAccount;
    
    public ATM(BankAccount linkedAccount) {
        this.linkedAccount = linkedAccount;
    }
    
    public void withdraw(int enteredPin, double amount) {
        System.out.println(" [ATM] Validating PIN...");
        if (linkedAccount.validatePin(enteredPin)) {
            System.out.println(" [ATM] PIN verified. Requesting debit...");
            linkedAccount.debit(amount); // Collaboration
        } else {
            System.out.println(" [ATM] Invalid PIN. Transaction failed.");
        }
    }
}

// File: Customer.java
class Customer {
    private String name;
    private ATM atm;
    
    public Customer(String name, ATM atm) { 
        this.name = name; 
        this.atm = atm; 
    }
    
    public void performWithdrawal(int pin, double amount) {
        System.out.println("\n--- " + name + " is requesting withdrawal of $" + amount + " ---");
        atm.withdraw(pin, amount); // Collaboration
    }
}

// File: ATMDemo.java
public class ATMDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456789", 1234, 5000.00);
        ATM atmMachine = new ATM(acc);
        Customer customerA = new Customer("Mr. Smith", atmMachine);
        
        // Correct PIN
        customerA.performWithdrawal(1234, 500.00);
        
        // Incorrect PIN
        customerA.performWithdrawal(9999, 100.00);
        
        System.out.println("\n--- Final Account Status ---");
        acc.showDetails();
    }
}
