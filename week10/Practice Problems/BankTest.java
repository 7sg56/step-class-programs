// File: BankAccount.java
public abstract class BankAccount {
    protected double balance;
    
    public BankAccount(double initialBalance) { 
        this.balance = initialBalance; 
    }
    
    public abstract void calculateInterest(); // Abstract method
    
    public void deposit(double amount) { // Concrete method
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited $%.2f. New Balance: $%.2f%n", amount, balance);
        }
    }
}

// File: SavingsAccount.java
class SavingsAccount extends BankAccount {
    public SavingsAccount(double initialBalance) { 
        super(initialBalance); 
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * 0.03;
        balance += interest;
        System.out.printf("SAVINGS Interest (3%%) applied: $%.2f%n", interest);
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}

// File: CurrentAccount.java
class CurrentAccount extends BankAccount {
    public CurrentAccount(double initialBalance) { 
        super(initialBalance); 
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * 0.01;
        balance += interest;
        System.out.printf("CURRENT Interest (1%%) applied: $%.2f%n", interest);
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}

public class BankTest {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(1000.0);
        
        System.out.println("--- Savings Account ---");
        savings.deposit(200.0);
        savings.calculateInterest();
    }
}
