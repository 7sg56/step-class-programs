// 4. Write a program to create a Vehicle rental system demonstrating
// static and instance members
// Hint =>
// a. Create a Vehicle class with private instance variables: vehicleId (String), brand
// (String), model (String), rentPerDay (double), isAvailable (boolean)

// 4

// b. Create static variables: totalVehicles (int), totalRevenue (double),
// companyName (String), rentalDays (int to track total rental days)
// c. Create a constructor and instance methods: rentVehicle(int days) which
// calculates rent and updates availability, returnVehicle() to make vehicle available
// again
// d. Create static methods: setCompanyName(String name), getTotalRevenue(),
// getAverageRentPerDay(), displayCompanyStats()
// e. Create a method calculateRent(int days) that returns rental amount and
// updates static revenue counter
// f. Create a displayVehicleInfo() method showing all vehicle details including
// rental history
// g. In main, demonstrate the difference between static and instance members by creating
// multiple vehicle objects, show how static variables are shared across all objects while
// instance variables are unique to each object

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Vehicle {
    // Private instance variables (unique to each object)
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    
    // Instance variables for rental history
    private int totalDaysRented;
    private double totalEarnings;
    private List<String> rentalHistory;
    
    // Static variables (shared across all objects)
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rental Company";
    private static int rentalDays = 0;
    
    // Static list to keep track of all vehicles
    private static List<Vehicle> allVehicles = new ArrayList<>();
    
    // DecimalFormat for currency display
    private static DecimalFormat df = new DecimalFormat("#,##0.00");
    
    // Constructor
    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalDaysRented = 0;
        this.totalEarnings = 0.0;
        this.rentalHistory = new ArrayList<>();
        
        // Update static variables
        totalVehicles++;
        allVehicles.add(this);
        
        System.out.println("Vehicle " + vehicleId + " (" + brand + " " + model + ") added to fleet.");
    }
    
    // Instance method: Rent vehicle for specified days
    public boolean rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is currently not available for rent.");
            return false;
        }
        
        if (days <= 0) {
            System.out.println("Invalid rental period. Days must be greater than 0.");
            return false;
        }
        
        double rentAmount = calculateRent(days);
        isAvailable = false;
        totalDaysRented += days;
        totalEarnings += rentAmount;
        
        // Add to rental history
        rentalHistory.add("Rented for " + days + " days - $" + df.format(rentAmount));
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RENTAL CONFIRMATION");
        System.out.println("=".repeat(50));
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Vehicle: " + brand + " " + model);
        System.out.println("Rental Days: " + days);
        System.out.println("Rate per Day: $" + df.format(rentPerDay));
        System.out.println("Total Amount: $" + df.format(rentAmount));
        System.out.println("Vehicle Status: RENTED");
        System.out.println("=".repeat(50));
        
        return true;
    }
    
    // Instance method: Return vehicle and make it available
    public boolean returnVehicle() {
        if (isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is already available and not rented out.");
            return false;
        }
        
        isAvailable = true;
        rentalHistory.add("Vehicle returned - Now available");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("VEHICLE RETURN CONFIRMATION");
        System.out.println("=".repeat(50));
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Vehicle: " + brand + " " + model);
        System.out.println("Status: AVAILABLE");
        System.out.println("Thank you for choosing " + companyName + "!");
        System.out.println("=".repeat(50));
        
        return true;
    }
    
    // Instance method: Calculate rent and update static revenue
    public double calculateRent(int days) {
        double rentAmount = days * rentPerDay;
        
        // Update static variables (shared across all objects)
        totalRevenue += rentAmount;
        rentalDays += days;
        
        return rentAmount;
    }
    
    // Instance method: Display vehicle information including rental history
    public void displayVehicleInfo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("VEHICLE INFORMATION");
        System.out.println("=".repeat(60));
        System.out.println("Vehicle ID       : " + vehicleId);
        System.out.println("Brand            : " + brand);
        System.out.println("Model            : " + model);
        System.out.println("Rent Per Day     : $" + df.format(rentPerDay));
        System.out.println("Availability     : " + (isAvailable ? "AVAILABLE" : "RENTED OUT"));
        System.out.println("Total Days Rented: " + totalDaysRented);
        System.out.println("Total Earnings   : $" + df.format(totalEarnings));
        
        System.out.println("\nRental History:");
        if (rentalHistory.isEmpty()) {
            System.out.println("  No rental history available");
        } else {
            for (int i = 0; i < rentalHistory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + rentalHistory.get(i));
            }
        }
        System.out.println("=".repeat(60));
    }
    
    // Static method: Set company name
    public static void setCompanyName(String name) {
        companyName = name;
        System.out.println("Company name updated to: " + companyName);
    }
    
    // Static method: Get total revenue
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    
    // Static method: Calculate and get average rent per day
    public static double getAverageRentPerDay() {
        if (rentalDays == 0) {
            return 0.0;
        }
        return totalRevenue / rentalDays;
    }
    
    // Static method: Display company statistics
    public static void displayCompanyStats() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("COMPANY STATISTICS - " + companyName.toUpperCase());
        System.out.println("=".repeat(70));
        System.out.println("Total Vehicles in Fleet    : " + totalVehicles);
        System.out.println("Total Revenue Generated    : $" + df.format(totalRevenue));
        System.out.println("Total Rental Days          : " + rentalDays);
        System.out.println("Average Revenue per Day    : $" + df.format(getAverageRentPerDay()));
        
        // Calculate availability statistics
        int availableCount = 0;
        int rentedCount = 0;
        
        for (Vehicle vehicle : allVehicles) {
            if (vehicle.isAvailable) {
                availableCount++;
            } else {
                rentedCount++;
            }
        }
        
        System.out.println("Available Vehicles         : " + availableCount);
        System.out.println("Currently Rented Vehicles  : " + rentedCount);
        System.out.println("Fleet Utilization Rate     : " + 
            df.format((double) rentedCount / totalVehicles * 100) + "%");
        System.out.println("=".repeat(70));
    }
    
    // Static method: Display all vehicles summary
    public static void displayAllVehicles() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL VEHICLES SUMMARY");
        System.out.println("=".repeat(80));
        System.out.printf("%-8s %-12s %-15s %-10s %-12s %-10s%n",
            "ID", "BRAND", "MODEL", "RATE/DAY", "STATUS", "EARNINGS");
        System.out.println("-".repeat(80));
        
        for (Vehicle vehicle : allVehicles) {
            System.out.printf("%-8s %-12s %-15s $%-9s %-12s $%-9s%n",
                vehicle.vehicleId,
                vehicle.brand,
                vehicle.model,
                df.format(vehicle.rentPerDay),
                (vehicle.isAvailable ? "AVAILABLE" : "RENTED"),
                df.format(vehicle.totalEarnings));
        }
        System.out.println("=".repeat(80));
    }
    
    // Getter methods for instance variables
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return isAvailable; }
    public int getTotalDaysRented() { return totalDaysRented; }
    public double getTotalEarnings() { return totalEarnings; }
    
    // Static getter methods
    public static int getTotalVehicles() { return totalVehicles; }
    public static String getCompanyName() { return companyName; }
    public static int getRentalDays() { return rentalDays; }
}

public class VehicleRental {
    public static void main(String[] args) {
        System.out.println("VEHICLE RENTAL SYSTEM - STATIC vs INSTANCE MEMBERS DEMO");
        System.out.println("=".repeat(70));
        
        // Demonstrate static method: Set company name
        Vehicle.setCompanyName("Premium Auto Rentals Inc.");
        
        System.out.println("\nInitial Company Stats (before creating any vehicles):");
        Vehicle.displayCompanyStats();
        
        // Create multiple vehicle objects
        System.out.println("\n" + "=".repeat(70));
        System.out.println("CREATING VEHICLE FLEET");
        System.out.println("=".repeat(70));
        
        Vehicle car1 = new Vehicle("V001", "Toyota", "Camry", 45.00);
        Vehicle car2 = new Vehicle("V002", "Honda", "Civic", 40.00);
        Vehicle car3 = new Vehicle("V003", "BMW", "X5", 85.00);
        Vehicle car4 = new Vehicle("V004", "Ford", "Mustang", 70.00);
        Vehicle car5 = new Vehicle("V005", "Mercedes", "C-Class", 90.00);
        
        // Show that static variables are shared across all objects
        System.out.println("\n" + "=".repeat(70));
        System.out.println("DEMONSTRATING STATIC vs INSTANCE MEMBERS");
        System.out.println("=".repeat(70));
        
        System.out.println("Static Variable (totalVehicles) - Same for all objects:");
        System.out.println("Vehicle.getTotalVehicles() = " + Vehicle.getTotalVehicles());
        System.out.println("Called from any object gives same result:");
        System.out.println("car1 reference: Total vehicles = " + Vehicle.getTotalVehicles());
        System.out.println("car3 reference: Total vehicles = " + Vehicle.getTotalVehicles());
        
        System.out.println("\nInstance Variables - Unique to each object:");
        System.out.println("car1.getVehicleId() = " + car1.getVehicleId() + " (unique to car1)");
        System.out.println("car2.getVehicleId() = " + car2.getVehicleId() + " (unique to car2)");
        System.out.println("car3.getRentPerDay() = $" + car3.getRentPerDay() + " (unique to car3)");
        System.out.println("car4.getRentPerDay() = $" + car4.getRentPerDay() + " (unique to car4)");
        
        // Demonstrate rental operations
        System.out.println("\n" + "=".repeat(70));
        System.out.println("RENTAL OPERATIONS - UPDATING STATIC AND INSTANCE MEMBERS");
        System.out.println("=".repeat(70));
        
        // Rent some vehicles
        car1.rentVehicle(5);  // This will update both instance and static variables
        car3.rentVehicle(3);  // This will update static variables shared by all
        car5.rentVehicle(7);  // This will update static variables again
        
        System.out.println("\nAfter rentals - Static variables updated:");
        System.out.println("Total Revenue (static): $" + 
            new DecimalFormat("#,##0.00").format(Vehicle.getTotalRevenue()));
        System.out.println("Total Rental Days (static): " + Vehicle.getRentalDays());
        
        System.out.println("\nInstance variables - Each object maintains its own:");
        System.out.println("car1 total earnings: $" + 
            new DecimalFormat("#,##0.00").format(car1.getTotalEarnings()));
        System.out.println("car3 total earnings: $" + 
            new DecimalFormat("#,##0.00").format(car3.getTotalEarnings()));
        System.out.println("car5 total earnings: $" + 
            new DecimalFormat("#,##0.00").format(car5.getTotalEarnings()));
        System.out.println("car2 total earnings: $" + 
            new DecimalFormat("#,##0.00").format(car2.getTotalEarnings()) + " (not rented)");
        
        // Display individual vehicle information
        System.out.println("\n" + "=".repeat(70));
        System.out.println("INDIVIDUAL VEHICLE DETAILS");
        System.out.println("=".repeat(70));
        
        car1.displayVehicleInfo();  // Shows instance-specific data
        car2.displayVehicleInfo();  // Shows different instance-specific data
        
        // Return some vehicles
        System.out.println("\n" + "=".repeat(70));
        System.out.println("RETURNING VEHICLES");
        System.out.println("=".repeat(70));
        
        car1.returnVehicle();
        car3.returnVehicle();
        
        // Try to rent the same vehicle again
        System.out.println("\nRenting car1 again after return:");
        car1.rentVehicle(2);
        
        // Display updated vehicle info
        car1.displayVehicleInfo();
        
        // Show all vehicles summary
        Vehicle.displayAllVehicles();
        
        // Final company statistics (static method using static variables)
        System.out.println("\n" + "=".repeat(70));
        System.out.println("FINAL COMPANY STATISTICS");
        System.out.println("=".repeat(70));
        Vehicle.displayCompanyStats();
        
        // Demonstrate accessing static members without creating objects
        System.out.println("\n" + "=".repeat(70));
        System.out.println("ACCESSING STATIC MEMBERS WITHOUT OBJECT REFERENCE");
        System.out.println("=".repeat(70));
        System.out.println("Company Name: " + Vehicle.getCompanyName());
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
        System.out.println("Total Revenue: $" + 
            new DecimalFormat("#,##0.00").format(Vehicle.getTotalRevenue()));
        System.out.println("Average Revenue per Day: $" + 
            new DecimalFormat("#,##0.00").format(Vehicle.getAverageRentPerDay()));
        
        // Final demonstration of static vs instance
        System.out.println("\n" + "=".repeat(70));
        System.out.println("FINAL DEMONSTRATION: STATIC vs INSTANCE MEMBERS");
        System.out.println("=".repeat(70));
        System.out.println("STATIC MEMBERS (shared by all objects):");
        System.out.println("  - totalVehicles: " + Vehicle.getTotalVehicles());
        System.out.println("  - totalRevenue: $" + 
            new DecimalFormat("#,##0.00").format(Vehicle.getTotalRevenue()));
        System.out.println("  - companyName: " + Vehicle.getCompanyName());
        System.out.println("  - rentalDays: " + Vehicle.getRentalDays());
        
        System.out.println("\nINSTANCE MEMBERS (unique to each object):");
        System.out.println("  car1 - ID: " + car1.getVehicleId() + 
            ", Brand: " + car1.getBrand() + ", Available: " + car1.isAvailable());
        System.out.println("  car2 - ID: " + car2.getVehicleId() + 
            ", Brand: " + car2.getBrand() + ", Available: " + car2.isAvailable());
        System.out.println("  car3 - ID: " + car3.getVehicleId() + 
            ", Brand: " + car3.getBrand() + ", Available: " + car3.isAvailable());
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("VEHICLE RENTAL SYSTEM DEMO COMPLETED");
        System.out.println("=".repeat(70));
    }
}