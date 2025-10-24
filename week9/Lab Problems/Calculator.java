/**
 * LAB PROBLEM 6: Static, Local, and Anonymous Inner Classes
 * Topic: Inner Class Variants
 * 
 * Create a Calculator class that includes:
 * 1. A static nested class Operation to perform addition.
 * 2. A local inner class inside a method to perform subtraction.
 * 3. An anonymous inner class implementing an interface MathOperation for multiplication.
 * Demonstrate all three operations.
 */

// Interface for anonymous inner class
interface MathOperation {
    double calculate(double a, double b);
}

public class Calculator {
    private String calculatorName;
    
    // Constructor
    public Calculator(String calculatorName) {
        this.calculatorName = calculatorName;
    }
    
    // 1. Static nested class for addition
    public static class Operation {
        public static double add(double a, double b) {
            return a + b;
        }
        
        public static void displayResult(String operation, double a, double b, double result) {
            System.out.println(operation + ": " + a + " + " + b + " = " + result);
        }
    }
    
    // 2. Method with local inner class for subtraction
    public double performSubtraction(double a, double b) {
        System.out.println("=== Using Local Inner Class for Subtraction ===");
        
        // Local inner class defined inside method
        class SubtractionOperation {
            public double subtract(double x, double y) {
                return x - y;
            }
            
            public void displaySubtraction(double x, double y, double result) {
                System.out.println("Subtraction: " + x + " - " + y + " = " + result);
            }
        }
        
        // Create instance of local inner class
        SubtractionOperation subOp = new SubtractionOperation();
        double result = subOp.subtract(a, b);
        subOp.displaySubtraction(a, b, result);
        
        return result;
    }
    
    // 3. Method using anonymous inner class for multiplication
    public double performMultiplication(double a, double b) {
        System.out.println("=== Using Anonymous Inner Class for Multiplication ===");
        
        // Anonymous inner class implementing MathOperation interface
        MathOperation multiply = new MathOperation() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        };
        
        double result = multiply.calculate(a, b);
        System.out.println("Multiplication: " + a + " * " + b + " = " + result);
        
        return result;
    }
    
    // Method to demonstrate all operations
    public void demonstrateAllOperations(double a, double b) {
        System.out.println("=== LAB PROBLEM 6: Static, Local, and Anonymous Inner Classes ===");
        System.out.println("Calculator: " + calculatorName);
        System.out.println("Performing operations on: " + a + " and " + b);
        System.out.println();
        
        // 1. Static nested class operation
        System.out.println("=== Using Static Nested Class for Addition ===");
        double addResult = Operation.add(a, b);
        Operation.displayResult("Addition", a, b, addResult);
        System.out.println();
        
        // 2. Local inner class operation
        performSubtraction(a, b);
        System.out.println();
        
        // 3. Anonymous inner class operation
        performMultiplication(a, b);
        System.out.println();
        
        // Additional demonstration with anonymous inner class for division
        System.out.println("=== Additional Anonymous Inner Class for Division ===");
        MathOperation divide = new MathOperation() {
            @Override
            public double calculate(double x, double y) {
                if (y != 0) {
                    return x / y;
                } else {
                    System.out.println("Error: Division by zero!");
                    return Double.NaN;
                }
            }
        };
        
        double divResult = divide.calculate(a, b);
        if (!Double.isNaN(divResult)) {
            System.out.println("Division: " + a + " / " + b + " = " + divResult);
        }
        System.out.println();
    }
    
    // Method to demonstrate static nested class access
    public static void demonstrateStaticNestedClass() {
        System.out.println("=== Static Nested Class Demonstration ===");
        System.out.println("Accessing static nested class without outer class instance:");
        
        double result1 = Operation.add(10, 5);
        Operation.displayResult("Static Addition", 10, 5, result1);
        
        double result2 = Operation.add(3.14, 2.86);
        Operation.displayResult("Static Addition", 3.14, 2.86, result2);
        System.out.println();
    }
    
    // Main method to demonstrate all inner class variants
    public static void main(String[] args) {
        // Create calculator instance
        Calculator calc = new Calculator("Scientific Calculator");
        
        // Demonstrate all operations
        calc.demonstrateAllOperations(15, 3);
        
        // Demonstrate static nested class
        demonstrateStaticNestedClass();
        
        // Additional demonstration with different values
        System.out.println("=== Additional Demonstration ===");
        Calculator calc2 = new Calculator("Basic Calculator");
        calc2.demonstrateAllOperations(20, 4);
        
        // Demonstrate local inner class with different method
        System.out.println("=== Local Inner Class in Different Method ===");
        calc2.performAdvancedOperations(100, 25);
    }
    
    // Additional method to show local inner class in different context
    public void performAdvancedOperations(double a, double b) {
        System.out.println("=== Advanced Operations with Local Inner Class ===");
        
        // Local inner class for power operation
        class PowerOperation {
            public double power(double base, double exponent) {
                return Math.pow(base, exponent);
            }
            
            public void displayPower(double base, double exponent, double result) {
                System.out.println("Power: " + base + "^" + exponent + " = " + result);
            }
        }
        
        PowerOperation powerOp = new PowerOperation();
        double powerResult = powerOp.power(a, 2);
        powerOp.displayPower(a, 2, powerResult);
        
        // Another local inner class for square root
        class SquareRootOperation {
            public double squareRoot(double number) {
                return Math.sqrt(number);
            }
            
            public void displaySquareRoot(double number, double result) {
                System.out.println("Square Root: √" + number + " = " + result);
            }
        }
        
        SquareRootOperation sqrtOp = new SquareRootOperation();
        double sqrtResult = sqrtOp.squareRoot(b);
        sqrtOp.displaySquareRoot(b, sqrtResult);
    }
}
