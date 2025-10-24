/**
 * Comprehensive demonstration of all Java OOP topics
 * This class demonstrates all 6 topics in a single program
 */
public class JavaOOPDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java OOP Concepts Demonstration ===\n");
        
        // Topic 1: toString() and getClass()
        demonstrateToStringAndGetClass();
        
        // Topic 2: equals() vs ==
        demonstrateEqualsVsReference();
        
        // Topic 3: hashCode() and equals() contract
        demonstrateHashCodeAndEquals();
        
        // Topic 4: Deep vs Shallow cloning
        demonstrateCloning();
        
        // Topic 5: Member and Static inner classes
        demonstrateInnerClasses();
        
        // Topic 6: Local and Anonymous inner classes
        demonstrateLocalAndAnonymousClasses();
    }
    
    // Topic 1: toString() and getClass()
    private static void demonstrateToStringAndGetClass() {
        System.out.println("=== TOPIC 1: toString() and getClass() ===");
        
        Employee emp1 = new Employee(101, "Alice Johnson", 75000);
        Employee emp2 = new Employee(102, "Bob Smith", 82000);
        
        System.out.println("Employee objects:");
        System.out.println(emp1);
        System.out.println(emp2);
        
        System.out.println("Class information:");
        System.out.println("emp1 class: " + emp1.getClass().getName());
        System.out.println("emp2 class: " + emp2.getClass().getName());
        System.out.println();
    }
    
    // Topic 2: equals() vs ==
    private static void demonstrateEqualsVsReference() {
        System.out.println("=== TOPIC 2: equals() vs == ===");
        
        Product prod1 = new Product(201, "Laptop");
        Product prod2 = new Product(201, "Laptop");
        Product prod3 = prod1;
        
        System.out.println("Product objects:");
        System.out.println("prod1: " + prod1);
        System.out.println("prod2: " + prod2);
        System.out.println("prod3: " + prod3);
        
        System.out.println("Reference comparison (==):");
        System.out.println("prod1 == prod2: " + (prod1 == prod2));
        System.out.println("prod1 == prod3: " + (prod1 == prod3));
        
        System.out.println("Content comparison (.equals()):");
        System.out.println("prod1.equals(prod2): " + prod1.equals(prod2));
        System.out.println("prod1.equals(prod3): " + prod1.equals(prod3));
        System.out.println();
    }
    
    // Topic 3: hashCode() and equals() contract
    private static void demonstrateHashCodeAndEquals() {
        System.out.println("=== TOPIC 3: hashCode() and equals() Contract ===");
        
        Student student1 = new Student(301, "Charlie Brown");
        Student student2 = new Student(301, "Charlie Brown");
        Student student3 = new Student(302, "Diana Prince");
        
        System.out.println("Student objects:");
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);
        
        System.out.println("Hash codes:");
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        
        System.out.println("Equals comparison:");
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student1.equals(student3): " + student1.equals(student3));
        System.out.println();
    }
    
    // Topic 4: Deep vs Shallow cloning
    private static void demonstrateCloning() {
        System.out.println("=== TOPIC 4: Deep vs Shallow Cloning ===");
        
        try {
            Library library = new Library("Tech Library");
            library.addBook(new Book("Java Programming", "John Doe", 500));
            library.addBook(new Book("Data Structures", "Jane Smith", 400));
            
            System.out.println("Original library: " + library);
            
            // Shallow cloning
            Library shallowClone = (Library) library.clone();
            System.out.println("Shallow clone: " + shallowClone);
            
            // Deep cloning
            Library deepClone = library.deepClone();
            System.out.println("Deep clone: " + deepClone);
            
            // Modify a book in shallow clone
            if (!shallowClone.getBooks().isEmpty()) {
                shallowClone.getBooks().get(0).setTitle("Modified Java Programming");
            }
            
            System.out.println("After modifying shallow clone:");
            System.out.println("Original: " + library);
            System.out.println("Shallow: " + shallowClone);
            System.out.println("Deep: " + deepClone);
            
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning error: " + e.getMessage());
        }
        System.out.println();
    }
    
    // Topic 5: Member and Static inner classes
    private static void demonstrateInnerClasses() {
        System.out.println("=== TOPIC 5: Member and Static Inner Classes ===");
        
        University university = new University("Tech University", "New York", 1950);
        
        // Create Department objects (member inner class)
        University.Department csDept = university.new Department("Computer Science", "Dr. Smith", 500);
        University.Department eeDept = university.new Department("Electrical Engineering", "Dr. Johnson", 300);
        
        csDept.displayDepartmentInfo();
        System.out.println();
        eeDept.displayDepartmentInfo();
        
        // Use static nested class
        University.ExamCell.conductExam("Midterm", "Data Structures");
        University.ExamCell.scheduleExam("Final", "Algorithms", "2024-04-15");
        System.out.println();
    }
    
    // Topic 6: Local and Anonymous inner classes
    private static void demonstrateLocalAndAnonymousClasses() {
        System.out.println("=== TOPIC 6: Local and Anonymous Inner Classes ===");
        
        Payment payment1 = new Payment("PAY001", 250.00, "Credit Card");
        Payment payment2 = new Payment("PAY002", 750.00, "Debit Card");
        
        payment1.processTransaction();
        System.out.println();
        payment2.processTransaction();
        System.out.println();
    }
}
