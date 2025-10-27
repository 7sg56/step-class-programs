// Interface for Anonymous Inner Class
interface MathOperation {
    int perform(int a, int b);
}

public class Calculator {
    private final String DEVICE_ID = "Calc-8000";
    // 1. Static Nested Class
    public static class Operation {
        public static int add(int a, int b) {
            System.out.println("[Static Nested] Performing Addition...");
            return a + b;
        }
    }

    public void performSubtraction(int x, int y) {
        // 2. Local Inner Class (defined inside the method)
        class Subtractor {
            public int subtract() {
                // Accesses outer class non-static member DEVICE_ID
                System.out.println("[Local Inner] (" + DEVICE_ID + ") Performing Subtraction...");
                return x - y;
            }
        }
        Subtractor sub = new Subtractor();
        System.out.println("Subtraction Result: " + sub.subtract());
    }

    public void performMultiplication(int x, int y) {
        // 3. Anonymous Inner Class (one-time implementation of MathOperation)
        MathOperation multiplier = new MathOperation() {
            @Override
            public int perform(int a, int b) {
                System.out.println("[Anonymous Inner] Performing Multiplication...");
                return a * b;
            }
        };
        System.out.println("Multiplication Result: " + multiplier.perform(x, y));
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("\n--- Testing Inner Classes ---\n");
        // 1. Static Nested Class
        int resultAdd = Calculator.Operation.add(10, 5);
        System.out.println("Addition Result: " + resultAdd);
        System.out.println("\n-------------------------\n");
        // 2. Local Inner Class
        calc.performSubtraction(20, 8);
        System.out.println("\n-------------------------\n");
        // 3. Anonymous Inner Class
        calc.performMultiplication(6, 4);
    }
}
