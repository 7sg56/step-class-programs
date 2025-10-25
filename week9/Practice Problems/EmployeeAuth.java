// File: EmployeeAuth.java
// equals(), ==, and hashCode() Problem: "Employee Authentication System"

import java.util.HashSet;

class Employee {
    private String empCode;
    private String name;
    
    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }
    
    // Override equals() - same empCode means same employee
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empCode != null ? empCode.equals(employee.empCode) : employee.empCode == null;
    }
    
    // Override hashCode() based on empCode
    @Override
    public int hashCode() {
        return empCode != null ? empCode.hashCode() : 0;
    }
    
    // Write toString() showing both fields
    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
    
    // Getters
    public String getEmpCode() {
        return empCode;
    }
    
    public String getName() {
        return name;
    }
}

class EmployeeAuth {
    public static void main(String[] args) {
        // 1. Employee e1 = new Employee("BL001", "Ritika");
        Employee e1 = new Employee("BL001", "Ritika");
        
        // 2. Employee e2 = new Employee("BL001", "Ritika S.");
        Employee e2 = new Employee("BL001", "Ritika S.");
        
        // 3. Compare using e1 == e2 and e1.equals(e2)
        System.out.println("Employee 1: " + e1);
        System.out.println("Employee 2: " + e2);
        System.out.println("e1 == e2: " + (e1 == e2)); // false - different objects
        System.out.println("e1.equals(e2): " + e1.equals(e2)); // true - same empCode
        
        // 4. Test using HashSet<Employee>
        HashSet<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);
        
        System.out.println("\nHashSet size: " + employeeSet.size()); // Should be 1 (duplicates removed)
        System.out.println("HashSet contains e1: " + employeeSet.contains(e1));
        System.out.println("HashSet contains e2: " + employeeSet.contains(e2));
        
        // Demonstrate hashCode consistency
        System.out.println("\nHash codes:");
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e2.hashCode(): " + e2.hashCode());
        System.out.println("Hash codes equal: " + (e1.hashCode() == e2.hashCode()));
    }
}
