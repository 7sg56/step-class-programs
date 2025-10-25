// File: Hospital.java
// Member Inner Class Problem: "Hospital Management"

class Hospital {
    private String name;
    
    public Hospital(String name) {
        this.name = name;
    }
    
    // Member Inner Class
    public class Department {
        private String deptName;
        
        public Department(String deptName) {
            this.deptName = deptName;
        }
        
        // Display department info along with hospital name
        public void displayInfo() {
            System.out.println("Hospital: " + Hospital.this.name);
            System.out.println("Department: " + this.deptName);
            System.out.println("Full Info: " + Hospital.this.name + " - " + this.deptName);
        }
        
        // Getter for department name
        public String getDeptName() {
            return deptName;
        }
        
        // Method to access outer class field
        public String getHospitalName() {
            return Hospital.this.name;
        }
    }
    
    // Method to create Department object
    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
    
    // Getter for hospital name
    public String getName() {
        return name;
    }
}

class HospitalManagement {
    public static void main(String[] args) {
        // 1. Create Hospital with 2 Departments, display info
        Hospital hospital = new Hospital("City General Hospital");
        
        // Create departments using the hospital's method
        Hospital.Department cardiology = hospital.createDepartment("Cardiology");
        Hospital.Department neurology = hospital.createDepartment("Neurology");
        
        System.out.println("=== Hospital Management System ===");
        System.out.println();
        
        // Display department information
        System.out.println("Department 1:");
        cardiology.displayInfo();
        System.out.println();
        
        System.out.println("Department 2:");
        neurology.displayInfo();
        System.out.println();
        
        // Demonstrate access to outer class from inner class
        System.out.println("=== Accessing Outer Class from Inner Class ===");
        System.out.println("Cardiology department belongs to: " + cardiology.getHospitalName());
        System.out.println("Neurology department belongs to: " + neurology.getHospitalName());
        
        // Create departments directly (alternative way)
        Hospital.Department emergency = hospital.new Department("Emergency");
        System.out.println("\nEmergency Department:");
        emergency.displayInfo();
        
        // Demonstrate that inner class instances are tied to outer class instance
        System.out.println("\n=== Inner Class Instance Relationship ===");
        System.out.println("All departments belong to the same hospital: " + hospital.getName());
        System.out.println("Cardiology hospital: " + cardiology.getHospitalName());
        System.out.println("Neurology hospital: " + neurology.getHospitalName());
        System.out.println("Emergency hospital: " + emergency.getHospitalName());
    }
}
