class BankAccount {
private double balance;
private int pin;
public BankAccount(double initialBalance, int pin) {
this.balance = initialBalance; this.pin = pin;
}
public boolean authenticate(int enteredPin) {
return this.pin == enteredPin;
}
public void withdraw(double amount) {
if (balance >= amount) {
balance -= amount;
System.out.printf(" Withdrawal SUCCESS. New Balance: $%.2f%n" , balance);
} else {
System.out.println(" Withdrawal FAILED. Insufficient funds.");
}
}
public void deposit(double amount) {
balance += amount;
System.out.printf(" Deposit SUCCESS. New Balance: $%.2f%n" , balance);
}
public void checkBalance() {
System.out.printf(" Current Balance: $%.2f%n" , balance);
}
}
class ATM {
public void performTransaction(String type, BankAccount acc, int pin, double amount) {
System.out.println("\n--- Initiating " + type + " --- ");
if (!acc.authenticate(pin)) {
System.out.println(" Authentication FAILED. Invalid PIN.");
return;
}
switch (type) {
case "Withdraw Money": acc.withdraw(amount); break;
case "Deposit Money": acc.deposit(amount); break;
case "Check Balance": acc.checkBalance(); break;
}
}
}
public class ATMTest {
public static void main(String[] args) {
BankAccount acc = new BankAccount(5000.00, 1234);
ATM atm = new ATM();
atm.performTransaction("Withdraw Money" , acc, 1234, 500.00);
atm.performTransaction("Check Balance" , acc, 1234, 0.0);
}
}