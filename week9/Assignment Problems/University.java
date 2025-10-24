/**
 * Topic 5: Member and Static Inner Classes
 * University class demonstrating non-static inner class and static nested class
 */
public class University {
    private String universityName;
    private String location;
    private int establishedYear;
    
    // Constructor
    public University(String universityName, String location, int establishedYear) {
        this.universityName = universityName;
        this.location = location;
        this.establishedYear = establishedYear;
    }
    
    // Getters
    public String getUniversityName() { return universityName; }
    public String getLocation() { return location; }
    public int getEstablishedYear() { return establishedYear; }
    
    // Non-static inner class - Department
    public class Department {
        private String departmentName;
        private String headOfDepartment;
        private int numberOfStudents;
        
        // Constructor
        public Department(String departmentName, String headOfDepartment, int numberOfStudents) {
            this.departmentName = departmentName;
            this.headOfDepartment = headOfDepartment;
            this.numberOfStudents = numberOfStudents;
        }
        
        // Getters
        public String getDepartmentName() { return departmentName; }
        public String getHeadOfDepartment() { return headOfDepartment; }
        public int getNumberOfStudents() { return numberOfStudents; }
        
        // Method that accesses outer class data
        public void displayDepartmentInfo() {
            System.out.println("=== Department Information ===");
            System.out.println("Department: " + departmentName);
            System.out.println("Head: " + headOfDepartment);
            System.out.println("Students: " + numberOfStudents);
            System.out.println("University: " + universityName);  // Accessing outer class field
            System.out.println("Location: " + location);           // Accessing outer class field
            System.out.println("Established: " + establishedYear); // Accessing outer class field
        }
        
        // Method to get university age
        public int getUniversityAge() {
            return 2024 - establishedYear;  // Accessing outer class field
        }
    }
    
    // Static nested class - ExamCell
    public static class ExamCell {
        private static int examIdCounter = 1000;
        
        // Static method for general exam operations
        public static void conductExam(String examType, String subject) {
            examIdCounter++;
            System.out.println("=== Exam Conducted ===");
            System.out.println("Exam ID: " + examIdCounter);
            System.out.println("Exam Type: " + examType);
            System.out.println("Subject: " + subject);
            System.out.println("Status: Completed");
        }
        
        // Static method to schedule exams
        public static void scheduleExam(String examType, String subject, String date) {
            System.out.println("=== Exam Scheduled ===");
            System.out.println("Exam Type: " + examType);
            System.out.println("Subject: " + subject);
            System.out.println("Date: " + date);
            System.out.println("Status: Scheduled");
        }
        
        // Static method to get exam statistics
        public static void getExamStatistics() {
            System.out.println("=== Exam Statistics ===");
            System.out.println("Total Exams Conducted: " + (examIdCounter - 1000));
            System.out.println("Next Exam ID: " + (examIdCounter + 1));
        }
    }
    
    // Method to demonstrate inner class usage
    public void demonstrateInnerClasses() {
        System.out.println("=== University: " + universityName + " ===");
        
        // Create Department objects (member inner class)
        Department csDept = new Department("Computer Science", "Dr. Smith", 500);
        Department eeDept = new Department("Electrical Engineering", "Dr. Johnson", 300);
        
        // Access inner class methods
        csDept.displayDepartmentInfo();
        System.out.println("University Age: " + csDept.getUniversityAge() + " years");
        
        System.out.println();
        eeDept.displayDepartmentInfo();
        System.out.println("University Age: " + eeDept.getUniversityAge() + " years");
    }
    
    public static void main(String[] args) {
        // Create University object
        University university = new University("Tech University", "New York", 1950);
        
        System.out.println("=== Member Inner Class Demonstration ===");
        university.demonstrateInnerClasses();
        
        System.out.println("\n=== Static Nested Class Demonstration ===");
        
        // Access static nested class methods using class name
        University.ExamCell.conductExam("Midterm", "Data Structures");
        University.ExamCell.conductExam("Final", "Algorithms");
        University.ExamCell.scheduleExam("Quiz", "Java Programming", "2024-03-15");
        
        System.out.println();
        University.ExamCell.getExamStatistics();
        
        System.out.println("\n=== Creating Inner Class Objects from Main ===");
        
        // Create Department objects using Outer.Inner syntax
        University.Department mathDept = university.new Department("Mathematics", "Dr. Brown", 200);
        University.Department physicsDept = university.new Department("Physics", "Dr. Wilson", 150);
        
        mathDept.displayDepartmentInfo();
        System.out.println();
        physicsDept.displayDepartmentInfo();
        
        System.out.println("\n=== Key Differences ===");
        System.out.println("Member Inner Class (Department):");
        System.out.println("- Can access outer class fields directly");
        System.out.println("- Needs instance of outer class to create");
        System.out.println("- Syntax: Outer.Inner inner = outer.new Inner()");
        
        System.out.println("\nStatic Nested Class (ExamCell):");
        System.out.println("- Cannot access outer class instance fields");
        System.out.println("- Can be accessed without outer class instance");
        System.out.println("- Syntax: Outer.Inner.method() or new Outer.Inner()");
    }
}
