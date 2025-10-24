/**
 * LAB PROBLEM 5: Member Inner Class
 * Topic: Inner Class – Member Inner Class
 * 
 * Create an Outer class with a private field message and a non-static inner class Inner that
 * displays the message. Create an object of Inner class using an instance of Outer and call its
 * display method.
 */

public class Outer {
    private String message = "Hello from Outer class!";
    
    // Constructor
    public Outer() {
        System.out.println("Outer class constructor called");
    }
    
    // Member Inner Class (non-static)
    public class Inner {
        private String innerMessage = "Hello from Inner class!";
        
        // Constructor
        public Inner() {
            System.out.println("Inner class constructor called");
        }
        
        // Method to display messages
        public void display() {
            System.out.println("=== Inner Class Display ===");
            System.out.println("Outer message: " + message);
            System.out.println("Inner message: " + innerMessage);
            System.out.println("Accessing outer field directly: " + message);
        }
        
        // Method to modify outer class field
        public void modifyOuterMessage(String newMessage) {
            message = newMessage;
            System.out.println("Modified outer message to: " + message);
        }
    }
    
    // Method to create and return inner class instance
    public Inner createInner() {
        return new Inner();
    }
    
    // Method to display outer class information
    public void displayOuter() {
        System.out.println("=== Outer Class Display ===");
        System.out.println("Outer message: " + message);
    }
    
    // Main method to demonstrate member inner class
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 5: Member Inner Class ===");
        
        // Create Outer class instance
        Outer outer = new Outer();
        outer.displayOuter();
        System.out.println();
        
        // Create Inner class instance using Outer instance
        Outer.Inner inner = outer.new Inner();
        inner.display();
        System.out.println();
        
        // Demonstrate that inner class can access outer class fields
        System.out.println("=== Demonstrating Inner Class Access to Outer Fields ===");
        inner.modifyOuterMessage("Modified by Inner class!");
        outer.displayOuter();
        System.out.println();
        
        // Create another inner class instance
        Outer.Inner inner2 = outer.new Inner();
        inner2.display();
        System.out.println();
        
        // Show that both inner instances share the same outer instance
        System.out.println("=== Demonstrating Shared Outer Instance ===");
        inner2.modifyOuterMessage("Modified by second Inner class!");
        inner.display(); // This will show the modified message
        System.out.println();
        
        // Demonstrate with different outer instances
        System.out.println("=== Demonstrating Different Outer Instances ===");
        Outer outer2 = new Outer();
        Outer.Inner inner3 = outer2.new Inner();
        inner3.display();
    }
}
