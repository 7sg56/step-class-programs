// File: PaymentGateway.java
// getClass() Problem: "Payment Gateway"

class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing wallet payment");
    }
}

class PaymentGateway {
    public static void main(String[] args) {
        // 1. Create array of Payment references with CreditCardPayment and WalletPayment
        Payment[] payments = {
            new CreditCardPayment(),
            new WalletPayment(),
            new Payment(),
            new CreditCardPayment()
        };
        
        // 2. Loop, call getClass().getSimpleName(), and pay()
        System.out.println("Processing payments using getClass():");
        System.out.println("=====================================");
        
        for (int i = 0; i < payments.length; i++) {
            Payment payment = payments[i];
            
            // Using getClass().getSimpleName() to get the actual class name
            String className = payment.getClass().getSimpleName();
            System.out.println("Payment " + (i + 1) + ": " + className);
            
            // Call the pay() method
            payment.pay();
            
            // Demonstrate getClass() vs instanceof
            System.out.println("Is CreditCardPayment? " + (payment instanceof CreditCardPayment));
            System.out.println("Is WalletPayment? " + (payment instanceof WalletPayment));
            System.out.println("Is Payment? " + (payment instanceof Payment));
            System.out.println("Actual class: " + payment.getClass().getName());
            System.out.println("---");
        }
        
        // Additional demonstration of getClass() usage
        System.out.println("\nDetailed class information:");
        for (Payment payment : payments) {
            Class<?> clazz = payment.getClass();
            System.out.println("Class: " + clazz.getSimpleName());
            System.out.println("Full name: " + clazz.getName());
            System.out.println("Superclass: " + clazz.getSuperclass().getSimpleName());
            System.out.println("---");
        }
    }
}
