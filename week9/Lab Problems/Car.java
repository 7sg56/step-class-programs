/**
 * LAB PROBLEM 2: toString() and getClass() Usage
 * Topic: Object Class Methods – toString(), getClass()
 * 
 * Create a Car class with brand, model, and price fields. Override the toString() method to
 * display object details. In the main method, print the class name of an object using
 * getClass().getName().
 */

public class Car {
    private String brand;
    private String model;
    private double price;
    
    // Constructor
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    // Getters
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Override toString() method for readable object representation
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
    
    // Main method to demonstrate toString() and getClass()
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 2: toString() and getClass() ===");
        
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 25000.0);
        Car car2 = new Car("Honda", "Civic", 22000.0);
        Car car3 = new Car("BMW", "X5", 55000.0);
        
        // Demonstrate toString() - automatically called when printing object
        System.out.println("Car objects using toString():");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
        System.out.println("Car 3: " + car3);
        System.out.println();
        
        // Demonstrate getClass() to get runtime class information
        System.out.println("Class information using getClass():");
        System.out.println("car1.getClass(): " + car1.getClass());
        System.out.println("car1.getClass().getName(): " + car1.getClass().getName());
        System.out.println("car1.getClass().getSimpleName(): " + car1.getClass().getSimpleName());
        System.out.println();
        
        // Demonstrate with different object types
        String str = "Hello World";
        Integer num = 42;
        
        System.out.println("Different object types:");
        System.out.println("String object class: " + str.getClass().getName());
        System.out.println("Integer object class: " + num.getClass().getName());
        System.out.println("Car object class: " + car1.getClass().getName());
        System.out.println();
        
        // Show that toString() is called automatically
        System.out.println("Automatic toString() invocation:");
        System.out.println("Direct print: " + car1);
        System.out.println("Explicit toString(): " + car1.toString());
    }
}
