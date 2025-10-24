import java.util.HashSet;
import java.util.Objects;

/**
 * Topic 3: hashCode() and equals() Contract
 * Student class demonstrating proper implementation of equals() and hashCode()
 */
public class Student {
    private int rollNo;
    private String name;
    
    // Constructor
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    
    // Getters
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    
    // Override equals() method to compare students by rollNo
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return rollNo == student.rollNo;
    }
    
    // Override hashCode() method to be consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }
    
    // Override toString() for better output
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
    
    public static void main(String[] args) {
        // Create Student objects
        Student student1 = new Student(101, "Alice");
        Student student2 = new Student(101, "Alice");  // Same rollNo, different object
        Student student3 = new Student(102, "Bob");
        Student student4 = new Student(101, "Charlie"); // Same rollNo as student1, different name
        
        System.out.println("Student Objects:");
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);
        System.out.println("student4: " + student4);
        
        System.out.println("\n=== equals() and hashCode() Results ===");
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("Hash codes equal: " + (student1.hashCode() == student2.hashCode()));
        
        System.out.println("\nstudent1.equals(student3): " + student1.equals(student3));
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        
        System.out.println("\nstudent1.equals(student4): " + student1.equals(student4));
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student4.hashCode(): " + student4.hashCode());
        
        // Demonstrate HashSet behavior
        System.out.println("\n=== HashSet Demonstration ===");
        HashSet<Student> studentSet = new HashSet<>();
        
        System.out.println("Adding students to HashSet:");
        System.out.println("Adding student1: " + studentSet.add(student1));
        System.out.println("Adding student2: " + studentSet.add(student2));
        System.out.println("Adding student3: " + studentSet.add(student3));
        System.out.println("Adding student4: " + studentSet.add(student4));
        
        System.out.println("\nHashSet contents:");
        for (Student student : studentSet) {
            System.out.println(student);
        }
        
        System.out.println("\nHashSet size: " + studentSet.size());
        System.out.println("Contains student1: " + studentSet.contains(student1));
        System.out.println("Contains student2: " + studentSet.contains(student2));
        
        // Demonstrate the contract
        System.out.println("\n=== hashCode() and equals() Contract ===");
        System.out.println("Rule: If two objects are equal (equals() returns true),");
        System.out.println("      they must have the same hashCode()");
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student1.hashCode() == student2.hashCode(): " + 
                          (student1.hashCode() == student2.hashCode()));
        System.out.println("Contract satisfied: " + 
                          (student1.equals(student2) == (student1.hashCode() == student2.hashCode())));
    }
}
