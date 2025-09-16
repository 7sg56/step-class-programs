import java.util.Random;

public class Vehicle {
    // Protected fields for inheritance - accessible to subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    
    // Private fields that require getter/setter access
    private String registrationNumber;
    private boolean isRunning;
    
    // Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 2024;
        this.engineType = "Gasoline";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }
    
    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }
    
    // Getter and setter methods for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public void setRunning(boolean running) {
        this.isRunning = running;
    }
    
    // Basic vehicle operations
    public void start() {
        this.isRunning = true;
        System.out.println("Vehicle started");
    }
    
    public void stop() {
        this.isRunning = false;
        System.out.println("Vehicle stopped");
    }
    
    public String getVehicleInfo() {
        return String.format("Vehicle Info:\n" +
                           "Brand: %s\n" +
                           "Model: %s\n" +
                           "Year: %d\n" +
                           "Engine Type: %s\n" +
                           "Registration Number: %s\n" +
                           "Status: %s",
                           brand, model, year, engineType, 
                           registrationNumber, 
                           isRunning ? "Running" : "Stopped");
    }
    
    // Display technical specifications
    public void displaySpecs() {
        System.out.println("=== Vehicle Technical Specifications ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Current Status: " + (isRunning ? "Running" : "Stopped"));
        System.out.println("=========================================");
    }
    
    // Helper method to generate random registration number
    private String generateRegistrationNumber() {
        Random random = new Random();
        StringBuilder regNumber = new StringBuilder();
        
        // Generate 3 random letters
        for (int i = 0; i < 3; i++) {
            regNumber.append((char) ('A' + random.nextInt(26)));
        }
        
        // Generate 3 random numbers
        for (int i = 0; i < 3; i++) {
            regNumber.append(random.nextInt(10));
        }
        
        return regNumber.toString();
    }
}

// Car class that extends Vehicle
class Car extends Vehicle {
    // Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;
    
    // Default constructor
    public Car() {
        super(); // Call parent default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Gasoline";
        this.transmissionType = "Automatic";
        System.out.println("Car default constructor called");
    }
    
    // Parameterized constructor
    public Car(String brand, String model, int year, String engineType, 
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Call parent parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }
    
    // Override start() method to include car-specific startup sequence
    @Override
    public void start() {
        super.start(); // Call parent start() method
        System.out.println("Car engine warming up...");
        System.out.println("Car ready to drive!");
    }
    
    // Override displaySpecs() to show both vehicle and car specifications
    @Override
    public void displaySpecs() {
        System.out.println("=== Car Technical Specifications ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Registration Number: " + getRegistrationNumber());
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission Type: " + transmissionType);
        System.out.println("Current Status: " + (isRunning() ? "Running" : "Stopped"));
        System.out.println("====================================");
    }
    
    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }
    
    public void playRadio() {
        System.out.println("Radio playing music");
    }
    
    // Getter methods for car-specific fields
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public String getTransmissionType() {
        return transmissionType;
    }
    
    // Setter methods for car-specific fields
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Constructor Chaining ===");
        System.out.println("\n1. Creating Car using default constructor:");
        Car car1 = new Car();
        
        System.out.println("\n2. Creating Car using parameterized constructor:");
        Car car2 = new Car("Toyota", "Camry", 2023, "V6", 4, "Hybrid", "CVT");
        
        System.out.println("\n=== Testing Inheritance of Fields and Methods ===");
        System.out.println("\n3. Accessing protected fields from parent:");
        System.out.println("Car1 Brand: " + car1.brand);
        System.out.println("Car1 Model: " + car1.model);
        System.out.println("Car1 Year: " + car1.year);
        System.out.println("Car1 Engine Type: " + car1.engineType);
        
        System.out.println("\n4. Calling inherited methods:");
        System.out.println("Car1 Vehicle Info:");
        System.out.println(car1.getVehicleInfo());
        
        System.out.println("\n5. Calling overridden methods:");
        System.out.println("Car1 starting (overridden method):");
        car1.start();
        
        System.out.println("\nCar1 displaySpecs (overridden method):");
        car1.displaySpecs();
        
        System.out.println("\n=== Testing Super Keyword Usage ===");
        System.out.println("\n6. Demonstrating super() in constructors:");
        System.out.println("Notice how parent constructors are called first");
        
        System.out.println("\n7. Demonstrating super.start() in overridden method:");
        System.out.println("Car2 starting (shows super.start() call):");
        car2.start();
        
        System.out.println("\n=== Testing Method Resolution ===");
        System.out.println("\n8. Calling methods that exist only in Car:");
        car1.openTrunk();
        car1.playRadio();
        
        System.out.println("\n9. Calling methods that exist in both Vehicle and Car:");
        System.out.println("Vehicle displaySpecs:");
        Vehicle vehicle = new Vehicle("Honda", "Civic", 2022, "I4");
        vehicle.displaySpecs();
        
        System.out.println("\nCar displaySpecs (overridden):");
        car2.displaySpecs();
        
        System.out.println("\n10. Testing polymorphic behavior:");
        Vehicle[] vehicles = {new Vehicle("Ford", "F-150", 2021, "V8"), car1, car2};
        
        System.out.println("\nPolymorphic method calls:");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("\nVehicle " + (i + 1) + " starting:");
            vehicles[i].start();
        }
        
        System.out.println("\n=== Testing Complete ===");
    }
}
