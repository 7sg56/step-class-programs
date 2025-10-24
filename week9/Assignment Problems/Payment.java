/**
 * Topic 6: Local and Anonymous Inner Classes
 * Payment class demonstrating local inner class and anonymous inner class
 */

// Interface for discount functionality
interface Discount {
    double applyDiscount(double amount);
}

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    
    // Constructor
    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    // Getters
    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    
    // Method that contains local inner class and anonymous inner class
    public void processTransaction() {
        System.out.println("=== Processing Payment ===");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Method: " + paymentMethod);
        
        // Local Inner Class - Validator (defined inside method body)
        class Validator {
            private static final double MIN_AMOUNT = 0.01;
            private static final double MAX_AMOUNT = 10000.00;
            
            public boolean isValidAmount(double amount) {
                return amount >= MIN_AMOUNT && amount <= MAX_AMOUNT;
            }
            
            public boolean isValidPaymentMethod(String method) {
                return method != null && !method.trim().isEmpty();
            }
            
            public void validatePayment() {
                System.out.println("\n=== Payment Validation ===");
                System.out.println("Amount validation: " + (isValidAmount(amount) ? "PASS" : "FAIL"));
                System.out.println("Payment method validation: " + (isValidPaymentMethod(paymentMethod) ? "PASS" : "FAIL"));
                
                if (isValidAmount(amount) && isValidPaymentMethod(paymentMethod)) {
                    System.out.println("Payment validation: SUCCESS");
                } else {
                    System.out.println("Payment validation: FAILED");
                }
            }
        }
        
        // Create and use local inner class
        Validator validator = new Validator();
        validator.validatePayment();
        
        // Anonymous Inner Class - implementing Discount interface
        System.out.println("\n=== Applying Discount ===");
        
        // Anonymous class for regular discount (5%)
        Discount regularDiscount = new Discount() {
            @Override
            public double applyDiscount(double amount) {
                return amount * 0.95; // 5% discount
            }
        };
        
        // Anonymous class for premium discount (10%)
        Discount premiumDiscount = new Discount() {
            @Override
            public double applyDiscount(double amount) {
                return amount * 0.90; // 10% discount
            }
        };
        
        // Anonymous class for student discount (15%)
        Discount studentDiscount = new Discount() {
            @Override
            public double applyDiscount(double amount) {
                return amount * 0.85; // 15% discount
            }
        };
        
        // Apply different discounts based on amount
        double finalAmount = amount;
        String discountType = "None";
        
        if (amount > 1000) {
            finalAmount = premiumDiscount.applyDiscount(amount);
            discountType = "Premium (10%)";
        } else if (amount > 500) {
            finalAmount = regularDiscount.applyDiscount(amount);
            discountType = "Regular (5%)";
        } else if (amount > 100) {
            finalAmount = studentDiscount.applyDiscount(amount);
            discountType = "Student (15%)";
        }
        
        // Make finalAmount effectively final for anonymous class
        final double finalAmountForProcessing = finalAmount;
        
        System.out.println("Original amount: $" + amount);
        System.out.println("Discount applied: " + discountType);
        System.out.println("Final amount: $" + String.format("%.2f", finalAmount));
        System.out.println("Amount saved: $" + String.format("%.2f", (amount - finalAmount)));
        
        // Demonstrate anonymous class with additional functionality
        System.out.println("\n=== Payment Processing ===");
        
        // Anonymous class for payment processing
        Runnable paymentProcessor = new Runnable() {
            @Override
            public void run() {
                System.out.println("Processing payment of $" + String.format("%.2f", finalAmountForProcessing));
                System.out.println("Payment method: " + paymentMethod);
                System.out.println("Transaction completed successfully!");
            }
        };
        
        // Execute the payment processing
        paymentProcessor.run();
        
        // Show local inner class accessing outer class variables
        System.out.println("\n=== Local Inner Class Access ===");
        System.out.println("Local Validator can access outer class fields:");
        System.out.println("- Payment ID: " + paymentId);
        System.out.println("- Amount: " + amount);
        System.out.println("- Payment Method: " + paymentMethod);
    }
    
    // Method to demonstrate different discount scenarios
    public void demonstrateDiscounts() {
        System.out.println("\n=== Discount Demonstration ===");
        
        double[] testAmounts = {50, 200, 600, 1200};
        
        for (double testAmount : testAmounts) {
            System.out.println("\nTesting amount: $" + testAmount);
            
            // Anonymous class for dynamic discount calculation
            Discount dynamicDiscount = new Discount() {
                @Override
                public double applyDiscount(double amount) {
                    if (amount > 1000) return amount * 0.90;
                    if (amount > 500) return amount * 0.95;
                    if (amount > 100) return amount * 0.85;
                    return amount;
                }
            };
            
            double discountedAmount = dynamicDiscount.applyDiscount(testAmount);
            System.out.println("Discounted amount: $" + String.format("%.2f", discountedAmount));
        }
    }
    
    public static void main(String[] args) {
        // Create Payment objects
        Payment payment1 = new Payment("PAY001", 250.00, "Credit Card");
        Payment payment2 = new Payment("PAY002", 750.00, "Debit Card");
        Payment payment3 = new Payment("PAY003", 1500.00, "PayPal");
        
        // Process transactions
        payment1.processTransaction();
        payment2.processTransaction();
        payment3.processTransaction();
        
        // Demonstrate discount scenarios
        payment1.demonstrateDiscounts();
        
        System.out.println("\n=== Key Concepts Demonstrated ===");
        System.out.println("1. Local Inner Class (Validator):");
        System.out.println("   - Defined inside a method");
        System.out.println("   - Can access outer class fields");
        System.out.println("   - Can access method parameters and local variables (if final or effectively final)");
        
        System.out.println("\n2. Anonymous Inner Class (Discount implementations):");
        System.out.println("   - One-time interface implementation");
        System.out.println("   - No explicit class name");
        System.out.println("   - Can access outer class fields");
        System.out.println("   - Used for event handlers, callbacks, etc.");
        
        System.out.println("\n3. Benefits:");
        System.out.println("   - Local classes: Encapsulation within method scope");
        System.out.println("   - Anonymous classes: Quick interface implementation");
        System.out.println("   - Both: Access to outer class members");
    }
}
