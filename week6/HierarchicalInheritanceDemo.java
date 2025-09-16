// File: HierarchicalInheritanceDemo.java
import java.util.Date;
import java.text.SimpleDateFormat;

// Base class Employee
class Employee {
    // Protected fields for inheritance
    protected String employeeId;
    protected String name;
    protected double baseSalary;
    protected String department;
    protected Date joiningDate;
    
    // Constructor
    public Employee(String employeeId, String name, double baseSalary, 
                   String department, Date joiningDate) {
        // Validate input parameters
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        if (joiningDate == null) {
            throw new IllegalArgumentException("Joining date cannot be null");
        }
        
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
        this.joiningDate = joiningDate;
        System.out.println("Employee " + name + " created in " + department);
    }
    
    // Methods that will be overridden differently by subclasses
    public double calculateSalary() {
        return baseSalary; // Default implementation
    }
    
    public String getJobDescription() {
        return "General Employee"; // Default implementation
    }
    
    public void performWork() {
        System.out.println("Employee is working");
    }
    
    public void attendMeeting() {
        System.out.println("Employee attending meeting");
    }
    
    // Final methods that cannot be overridden
    public final String getEmployeeId() {
        return employeeId;
    }
    
    public final void printEmployeeDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("=== Employee Details ===");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + String.format("%.2f", baseSalary));
        System.out.println("Joining Date: " + sdf.format(joiningDate));
        System.out.println("Job Description: " + getJobDescription());
        System.out.println("Calculated Salary: $" + String.format("%.2f", calculateSalary()));
        System.out.println("========================");
    }
    
    // Methods that provide default behavior
    public void takeBreak() {
        System.out.println(name + " is taking a 15-minute break");
    }
    
    public void clockIn() {
        System.out.println(name + " clocked in at " + new Date());
    }
    
    public void clockOut() {
        System.out.println(name + " clocked out at " + new Date());
    }
}

// Developer class extends Employee
class Developer extends Employee {
    // Developer-specific fields
    private String[] programmingLanguages;
    private String experienceLevel;
    private int projectsCompleted;
    
    // Constructor
    public Developer(String employeeId, String name, double baseSalary, 
                    String department, Date joiningDate, String[] programmingLanguages,
                    String experienceLevel, int projectsCompleted) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.programmingLanguages = programmingLanguages;
        this.experienceLevel = experienceLevel;
        this.projectsCompleted = projectsCompleted;
        System.out.println("Developer profile created");
    }
    
    // Override parent methods with @Override annotation
    @Override
    public double calculateSalary() {
        double experienceBonus = 0;
        double projectBonus = projectsCompleted * 500; // $500 per project
        
        switch (experienceLevel.toLowerCase()) {
            case "senior":
                experienceBonus = baseSalary * 0.3; // 30% bonus
                break;
            case "mid":
                experienceBonus = baseSalary * 0.15; // 15% bonus
                break;
            case "junior":
                experienceBonus = baseSalary * 0.05; // 5% bonus
                break;
        }
        
        return baseSalary + experienceBonus + projectBonus;
    }
    
    @Override
    public String getJobDescription() {
        return "Software Developer";
    }
    
    @Override
    public void performWork() {
        System.out.println("Developer is coding and debugging");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Developer in technical meeting");
    }
    
    // Developer-specific methods
    public void writeCode() {
        System.out.println("Writing code in " + String.join(", ", programmingLanguages));
    }
    
    public void reviewCode() {
        System.out.println("Reviewing team's code");
    }
    
    public void deployApplication() {
        System.out.println("Deploying application to production");
    }
    
    // Getter methods
    public String[] getProgrammingLanguages() { return programmingLanguages; }
    public String getExperienceLevel() { return experienceLevel; }
    public int getProjectsCompleted() { return projectsCompleted; }
}

// Manager class extends Employee
class Manager extends Employee {
    // Manager-specific fields
    private int teamSize;
    private String managementLevel;
    private double budgetResponsibility;
    
    // Constructor
    public Manager(String employeeId, String name, double baseSalary, 
                  String department, Date joiningDate, int teamSize,
                  String managementLevel, double budgetResponsibility) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.teamSize = teamSize;
        this.managementLevel = managementLevel;
        this.budgetResponsibility = budgetResponsibility;
        System.out.println("Manager profile created");
    }
    
    // Override parent methods differently than Developer
    @Override
    public double calculateSalary() {
        double teamSizeBonus = teamSize * 1000; // $1000 per team member
        double managementBonus = 0;
        
        switch (managementLevel.toLowerCase()) {
            case "director":
                managementBonus = baseSalary * 0.5; // 50% bonus
                break;
            case "manager":
                managementBonus = baseSalary * 0.3; // 30% bonus
                break;
            case "team lead":
                managementBonus = baseSalary * 0.15; // 15% bonus
                break;
        }
        
        return baseSalary + teamSizeBonus + managementBonus;
    }
    
    @Override
    public String getJobDescription() {
        return "Team Manager";
    }
    
    @Override
    public void performWork() {
        System.out.println("Manager is coordinating team activities");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Manager leading strategic meeting");
    }
    
    // Manager-specific methods
    public void conductPerformanceReview() {
        System.out.println("Conducting team performance review");
    }
    
    public void assignTasks() {
        System.out.println("Assigning tasks to team members");
    }
    
    public void manageBudget() {
        System.out.println("Managing department budget of $" + String.format("%.2f", budgetResponsibility));
    }
    
    // Getter methods
    public int getTeamSize() { return teamSize; }
    public String getManagementLevel() { return managementLevel; }
    public double getBudgetResponsibility() { return budgetResponsibility; }
}

// Intern class extends Employee
class Intern extends Employee {
    // Intern-specific fields
    private String university;
    private int internshipDuration;
    private String mentor;
    private boolean isFullTime;
    
    // Constructor
    public Intern(String employeeId, String name, double baseSalary, 
                 String department, Date joiningDate, String university,
                 int internshipDuration, String mentor, boolean isFullTime) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.university = university;
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
        this.isFullTime = isFullTime;
        System.out.println("Intern onboarded");
    }
    
    // Override methods with intern-specific behavior
    @Override
    public double calculateSalary() {
        // Interns get stipend (much lower than employees)
        return baseSalary * 0.3; // 30% of base salary as stipend
    }
    
    @Override
    public String getJobDescription() {
        return "Intern";
    }
    
    @Override
    public void performWork() {
        System.out.println("Intern is learning and assisting");
    }
    
    // DON'T override attendMeeting() - use parent implementation
    
    // Intern-specific methods
    public void attendTraining() {
        System.out.println("Intern attending training session");
    }
    
    public void submitReport() {
        System.out.println("Submitting weekly progress report");
    }
    
    public void seekMentorship() {
        System.out.println("Getting guidance from mentor " + mentor);
    }
    
    // Getter methods
    public String getUniversity() { return university; }
    public int getInternshipDuration() { return internshipDuration; }
    public String getMentor() { return mentor; }
    public boolean isFullTime() { return isFullTime; }
}

// EmployeeManager utility class
class EmployeeManager {
    public static double calculateTotalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                total += emp.calculateSalary();
            }
        }
        return total;
    }
    
    public static void generatePayrollReport(Employee[] employees) {
        System.out.println("\n=== PAYROLL REPORT ===");
        double total = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.name + " (" + emp.getJobDescription() + 
                                 "): $" + String.format("%.2f", emp.calculateSalary()));
                total += emp.calculateSalary();
            }
        }
        System.out.println("TOTAL PAYROLL: $" + String.format("%.2f", total));
        System.out.println("====================\n");
    }
    
    public static void generateJobDescriptionReport(Employee[] employees) {
        System.out.println("\n=== JOB DESCRIPTION REPORT ===");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.name + ": " + emp.getJobDescription());
            }
        }
        System.out.println("=============================\n");
    }
    
    public static void processEmployeeWork(Employee[] employees) {
        System.out.println("\n=== WORK ACTIVITIES ===");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println("\n" + emp.name + " (" + emp.getJobDescription() + "):");
                emp.performWork();
                emp.attendMeeting();
            }
        }
        System.out.println("======================\n");
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Hierarchical Inheritance Demonstration ===\n");
        
        // Create array of Employee references pointing to different subclass objects
        Employee[] employees = new Employee[4];
        
        // Initialize with different employee types
        System.out.println("1. Creating Employee Objects:");
        Date currentDate = new Date();
        
        // Create Developer
        String[] devLanguages = {"Java", "Python", "JavaScript"};
        employees[0] = new Developer("DEV001", "Alice Johnson", 80000, "Engineering", 
                                   currentDate, devLanguages, "Senior", 12);
        
        // Create Manager
        employees[1] = new Manager("MGR001", "Bob Smith", 90000, "Engineering", 
                                 currentDate, 8, "Manager", 500000);
        
        // Create Intern
        employees[2] = new Intern("INT001", "Charlie Brown", 30000, "Engineering", 
                                currentDate, "Tech University", 12, "DEV001", true);
        
        // Create another Developer
        String[] devLanguages2 = {"C++", "Python"};
        employees[3] = new Developer("DEV002", "Diana Prince", 70000, "Engineering", 
                                   currentDate, devLanguages2, "Mid", 5);
        
        // Demonstrate polymorphic method calls
        System.out.println("\n2. Polymorphic Method Calls:");
        System.out.println("Looping through array calling same methods on different types:");
        
        for (int i = 0; i < employees.length; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");
            employees[i].performWork();
            employees[i].attendMeeting();
            System.out.println("Salary: $" + String.format("%.2f", employees[i].calculateSalary()));
        }
        
        // Test @Override annotation benefits
        System.out.println("\n3. Testing @Override Annotation Benefits:");
        System.out.println("All methods are properly overridden with @Override annotation");
        System.out.println("This ensures compile-time error detection for method signature mismatches");
        
        // Test method overriding vs method overloading
        System.out.println("\n4. Method Overriding vs Method Overloading:");
        System.out.println("Overridden methods replace parent behavior:");
        employees[0].performWork(); // Developer's version
        employees[1].performWork(); // Manager's version
        employees[2].performWork(); // Intern's version
        
        System.out.println("\nInherited methods work unchanged:");
        employees[0].takeBreak(); // Same for all
        employees[1].clockIn();   // Same for all
        
        // Demonstrate instanceof and type checking
        System.out.println("\n5. Instanceof and Type Checking:");
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            System.out.println("\nEmployee " + (i + 1) + " type checking:");
            System.out.println("  instanceof Employee: " + (emp instanceof Employee));
            System.out.println("  instanceof Developer: " + (emp instanceof Developer));
            System.out.println("  instanceof Manager: " + (emp instanceof Manager));
            System.out.println("  instanceof Intern: " + (emp instanceof Intern));
        }
        
        // Cast to specific types to access subclass-specific methods
        System.out.println("\n6. Casting to Access Subclass-Specific Methods:");
        for (Employee emp : employees) {
            if (emp instanceof Developer) {
                Developer dev = (Developer) emp;
                dev.writeCode();
                dev.reviewCode();
            } else if (emp instanceof Manager) {
                Manager mgr = (Manager) emp;
                mgr.conductPerformanceReview();
                mgr.assignTasks();
            } else if (emp instanceof Intern) {
                Intern intern = (Intern) emp;
                intern.attendTraining();
                intern.submitReport();
            }
        }
        
        // Test final method inheritance
        System.out.println("\n7. Final Method Inheritance:");
        System.out.println("Final methods cannot be overridden - all subclasses inherit exact same behavior:");
        for (Employee emp : employees) {
            System.out.println("\n" + emp.name + " details:");
            emp.printEmployeeDetails(); // Final method - same for all
        }
        
        // Create EmployeeManager utility class demonstrations
        System.out.println("\n8. EmployeeManager Utility Class Demonstrations:");
        
        // Calculate total payroll using polymorphic calculateSalary()
        double totalPayroll = EmployeeManager.calculateTotalPayroll(employees);
        System.out.println("Total Company Payroll: $" + String.format("%.2f", totalPayroll));
        
        // Generate reports
        EmployeeManager.generatePayrollReport(employees);
        EmployeeManager.generateJobDescriptionReport(employees);
        EmployeeManager.processEmployeeWork(employees);
        
        // Demonstrate benefits of hierarchical inheritance
        System.out.println("\n9. Benefits of Hierarchical Inheritance Demonstrated:");
        System.out.println("✓ Code Reuse: Common employee functionality in base class");
        System.out.println("✓ Polymorphism: Same interface, different implementations");
        System.out.println("✓ Extensibility: Easy to add new employee types");
        System.out.println("✓ Maintainability: Changes to base class affect all subclasses");
        System.out.println("✓ Type Safety: Compile-time checking with @Override");
        System.out.println("✓ Final Methods: Prevent critical methods from being overridden");
        
        System.out.println("\n=== Hierarchical Inheritance Demo Complete ===");
    }
}
