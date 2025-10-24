/**
 * Topic 1: Using toString() and getClass()
 * Employee class demonstrating toString() override and getClass() usage
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    
    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    // Override toString() method to provide meaningful string representation
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    
    public static void main(String[] args) {
        // Create multiple Employee objects
        Employee emp1 = new Employee(101, "John Doe", 50000.0);
        Employee emp2 = new Employee(102, "Jane Smith", 60000.0);
        Employee emp3 = new Employee(103, "Bob Johnson", 55000.0);
        
        // Print employee details using toString()
        System.out.println("Employee Details:");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        
        // Print class name using getClass().getName()
        System.out.println("\nClass Information:");
        System.out.println("emp1 class name: " + emp1.getClass().getName());
        System.out.println("emp2 class name: " + emp2.getClass().getName());
        System.out.println("emp3 class name: " + emp3.getClass().getName());
        
        // Demonstrate getClass() with different object types
        Object obj = new Employee(104, "Alice Brown", 70000.0);
        System.out.println("Object reference class name: " + obj.getClass().getName());
    }
}
