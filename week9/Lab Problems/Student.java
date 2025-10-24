/**
 * LAB PROBLEM 3: hashCode() and equals() Contract
 * Topic: Object Class Methods – hashCode() and equals() Relationship
 * 
 * Create a Student class with id and name fields. Override both equals() and hashCode()
 * methods to ensure two students with the same id are treated as equal. Demonstrate storing
 * Student objects in a HashSet and show how duplicates are handled.
 */

import java.util.HashSet;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    
    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id;
    }
    
    // Override hashCode() method - must be consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    // Override toString() for better representation
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
    
    // Main method to demonstrate hashCode() and equals() contract
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 3: hashCode() and equals() Contract ===");
        
        // Create Student objects
        Student student1 = new Student(101, "Alice");
        Student student2 = new Student(102, "Bob");
        Student student3 = new Student(101, "Alice"); // Same ID as student1
        Student student4 = new Student(103, "Charlie");
        Student student5 = new Student(101, "David"); // Same ID as student1, different name
        
        System.out.println("Created students:");
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        System.out.println("Student 3: " + student3);
        System.out.println("Student 4: " + student4);
        System.out.println("Student 5: " + student5);
        System.out.println();
        
        // Demonstrate equals() method
        System.out.println("Equals comparison:");
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student1.equals(student3): " + student1.equals(student3));
        System.out.println("student1.equals(student5): " + student1.equals(student5));
        System.out.println();
        
        // Demonstrate hashCode() method
        System.out.println("HashCode values:");
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        System.out.println("student4.hashCode(): " + student4.hashCode());
        System.out.println("student5.hashCode(): " + student5.hashCode());
        System.out.println();
        
        // Demonstrate HashSet behavior
        System.out.println("HashSet demonstration:");
        HashSet<Student> studentSet = new HashSet<>();
        
        System.out.println("Adding students to HashSet...");
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3); // Should not be added (duplicate of student1)
        studentSet.add(student4);
        studentSet.add(student5); // Should not be added (duplicate of student1)
        
        System.out.println("HashSet size: " + studentSet.size());
        System.out.println("HashSet contents:");
        for (Student student : studentSet) {
            System.out.println("  " + student);
        }
        System.out.println();
        
        // Verify that duplicates are avoided
        System.out.println("Checking for duplicates:");
        System.out.println("student1 in set: " + studentSet.contains(student1));
        System.out.println("student3 in set: " + studentSet.contains(student3));
        System.out.println("student5 in set: " + studentSet.contains(student5));
    }
}
