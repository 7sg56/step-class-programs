// File: VehicleRental.java
// Object Modeling & toString() Problem: "Vehicle Rental System"

class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    // Constructor initializing all fields
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    // Override toString() to print: "Vehicle: [registrationNo], Type: [type], Rate: $[ratePerDay]/day"
    @Override
    public String toString() {
        return "Vehicle: " + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
    }
    
    // Getters for all fields
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRatePerDay() {
        return ratePerDay;
    }
}

class VehicleRental {
    public static void main(String[] args) {
        // 1. Create Vehicle("MH12AB1234", "Sedan", 1500)
        Vehicle vehicle1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        
        // 2. Print the Vehicle object and observe output
        System.out.println("Vehicle 1: " + vehicle1);
        
        // 3. Create another vehicle and compare
        Vehicle vehicle2 = new Vehicle("DL01CD5678", "SUV", 2000);
        System.out.println("Vehicle 2: " + vehicle2);
        
        // Demonstrate toString() override
        System.out.println("\nDemonstrating toString() override:");
        System.out.println("Direct print: " + vehicle1);
        System.out.println("Using toString(): " + vehicle1.toString());
    }
}
