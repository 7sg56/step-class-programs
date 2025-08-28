import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Employee {
    // Private variables
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    
    // Static variable to track total employees
    private static int totalEmployees = 0;
    private static List<Employee> allEmployees = new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("#,##0.00");
    
    // Additional variables for different employee types
    private double hourlyRate;
    private int hoursWorked;
    private double bonus;
    private double fixedAmount;
    
    // Constructor for Full-time employees
    public Employee(String empId, String empName, String department, double baseSalary, double bonus) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.empType = "Full-time";
        totalEmployees++;
        allEmployees.add(this);
    }
    
    // Constructor for Part-time employees
    public Employee(String empId, String empName, String department, double hourlyRate, int hoursWorked) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.empType = "Part-time";
        totalEmployees++;
        allEmployees.add(this);
    }
    
    // Constructor for Contract employees
    public Employee(String empId, String empName, String department, String contractType, double fixedAmount) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.fixedAmount = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
        allEmployees.add(this);
    }
    
    // Overloaded calculateSalary() methods
    
    // Calculate salary for full-time employees (base salary + bonus)
    public double calculateSalary() {
        if (empType.equals("Full-time")) {
            return baseSalary + bonus;
        }
        return 0.0;
    }
    
    // Calculate salary for part-time employees (hourly rate × hours)
    public double calculateSalary(double hourlyRate, int hours) {
        if (empType.equals("Part-time")) {
            return hourlyRate * hours;
        }
        return 0.0;
    }
    
    // Calculate salary for contract employees (fixed amount)
    public double calculateSalary(double fixedAmount) {
        if (empType.equals("Contract")) {
            return fixedAmount;
        }
        return 0.0;
    }
    
    // Overloaded calculateTax() methods with different tax rates
    
    // Tax calculation for full-time employees (20% tax rate)
    public double calculateTax() {
        if (empType.equals("Full-time")) {
            double salary = calculateSalary();
            return salary * 0.20; // 20% tax for full-time
        }
        return 0.0;
    }
    
    // Tax calculation for part-time employees (15% tax rate)
    public double calculateTax(String employeeType) {
        if (empType.equals("Part-time") && employeeType.equals("Part-time")) {
            double salary = calculateSalary(hourlyRate, hoursWorked);
            return salary * 0.15; // 15% tax for part-time
        }
        return 0.0;
    }
    
    // Tax calculation for contract employees (10% tax rate)
    public double calculateTax(double contractAmount) {
        if (empType.equals("Contract")) {
            return contractAmount * 0.10; // 10% tax for contract
        }
        return 0.0;
    }
    
    // Method to get calculated salary based on employee type
    private double getSalary() {
        switch (empType) {
            case "Full-time":
                return calculateSalary();
            case "Part-time":
                return calculateSalary(hourlyRate, hoursWorked);
            case "Contract":
                return calculateSalary(fixedAmount);
            default:
                return 0.0;
        }
    }
    
    // Method to get calculated tax based on employee type
    private double getTax() {
        switch (empType) {
            case "Full-time":
                return calculateTax();
            case "Part-time":
                return calculateTax("Part-time");
            case "Contract":
                return calculateTax(fixedAmount);
            default:
                return 0.0;
        }
    }
    
    // Generate pay slip with employee details, salary, and tax
    public void generatePaySlip() {
        double salary = getSalary();
        double tax = getTax();
        double netSalary = salary - tax;
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               PAY SLIP");
        System.out.println("=".repeat(50));
        System.out.println("Employee ID    : " + empId);
        System.out.println("Employee Name  : " + empName);
        System.out.println("Department     : " + department);
        System.out.println("Employee Type  : " + empType);
        
        if (empType.equals("Full-time")) {
            System.out.println("Base Salary    : $" + df.format(baseSalary));
            System.out.println("Bonus          : $" + df.format(bonus));
        } else if (empType.equals("Part-time")) {
            System.out.println("Hourly Rate    : $" + df.format(hourlyRate));
            System.out.println("Hours Worked   : " + hoursWorked);
        } else if (empType.equals("Contract")) {
            System.out.println("Fixed Amount   : $" + df.format(fixedAmount));
        }
        
        System.out.println("-".repeat(50));
        System.out.println("Gross Salary   : $" + df.format(salary));
        System.out.println("Tax Deducted   : $" + df.format(tax));
        System.out.println("Net Salary     : $" + df.format(netSalary));
        System.out.println("=".repeat(50));
    }
    
    // Display formatted employee information
    public void displayEmployeeInfo() {
        double salary = getSalary();
        double tax = getTax();
        
        System.out.printf("%-8s %-15s %-12s %-10s $%-10s $%-8s $%-10s%n",
            empId, empName, department, empType, 
            df.format(salary), df.format(tax), df.format(salary - tax));
    }
    
    // Static method to get total number of employees
    public static int getTotalEmployees() {
        return totalEmployees;
    }
    
    // Static method to generate company-wide payroll report
    public static void generateCompanyPayrollReport() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                    COMPANY PAYROLL REPORT");
        System.out.println("=".repeat(80));
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("-".repeat(80));
        System.out.printf("%-8s %-15s %-12s %-10s %-12s %-10s %-12s%n",
            "EMP ID", "NAME", "DEPARTMENT", "TYPE", "GROSS", "TAX", "NET");
        System.out.println("-".repeat(80));
        
        double totalGross = 0, totalTax = 0, totalNet = 0;
        int fullTimeCount = 0, partTimeCount = 0, contractCount = 0;
        
        for (Employee emp : allEmployees) {
            emp.displayEmployeeInfo();
            
            double salary = emp.getSalary();
            double tax = emp.getTax();
            totalGross += salary;
            totalTax += tax;
            totalNet += (salary - tax);
            
            switch (emp.empType) {
                case "Full-time": fullTimeCount++; break;
                case "Part-time": partTimeCount++; break;
                case "Contract": contractCount++; break;
            }
        }
        
        System.out.println("-".repeat(80));
        System.out.printf("%-47s $%-10s $%-8s $%-10s%n", "TOTALS:", 
            df.format(totalGross), df.format(totalTax), df.format(totalNet));
        System.out.println("=".repeat(80));
        
        System.out.println("\nEmployee Type Summary:");
        System.out.println("Full-time employees: " + fullTimeCount);
        System.out.println("Part-time employees: " + partTimeCount);
        System.out.println("Contract employees: " + contractCount);
        System.out.println("=".repeat(80));
    }
    
    // Getter methods
    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getDepartment() { return department; }
    public String getEmpType() { return empType; }
}

public class PayrollSystem {
    public static void main(String[] args) {
        System.out.println("Employee Payroll System - Method Overloading Demo");
        System.out.println("=".repeat(60));
        
        // Create different types of employee objects
        
        // Full-time employees (empId, empName, department, baseSalary, bonus)
        Employee emp1 = new Employee("FT001", "John Smith", "Engineering", 80000.0, 10000.0);
        Employee emp2 = new Employee("FT002", "Sarah Johnson", "Marketing", 65000.0, 8000.0);
        Employee emp3 = new Employee("FT003", "Mike Davis", "Finance", 75000.0, 9500.0);
        
        // Part-time employees (empId, empName, department, hourlyRate, hoursWorked)
        Employee emp4 = new Employee("PT001", "Alice Brown", "HR", 25.0, 120);
        Employee emp5 = new Employee("PT002", "Bob Wilson", "IT Support", 30.0, 100);
        
        // Contract employees (empId, empName, department, contractType, fixedAmount)
        Employee emp6 = new Employee("CT001", "Lisa Garcia", "Consulting", "Project", 45000.0);
        Employee emp7 = new Employee("CT002", "David Lee", "Design", "Freelance", 35000.0);
        
        System.out.println("Created " + Employee.getTotalEmployees() + " employees successfully!\n");
        
        // Demonstrate method overloading by calling the same method names with different parameters
        System.out.println("=".repeat(60));
        System.out.println("DEMONSTRATING METHOD OVERLOADING");
        System.out.println("=".repeat(60));
        
        // Full-time employee - calculateSalary() and calculateTax()
        System.out.println("\n1. Full-time Employee (John Smith):");
        System.out.println("   Salary calculation: calculateSalary() = $" + 
            new DecimalFormat("#,##0.00").format(emp1.calculateSalary()));
        System.out.println("   Tax calculation: calculateTax() = $" + 
            new DecimalFormat("#,##0.00").format(emp1.calculateTax()));
        
        // Part-time employee - calculateSalary(hourlyRate, hours) and calculateTax("Part-time")
        System.out.println("\n2. Part-time Employee (Alice Brown):");
        System.out.println("   Salary calculation: calculateSalary(25.0, 120) = $" + 
            new DecimalFormat("#,##0.00").format(emp4.calculateSalary(25.0, 120)));
        System.out.println("   Tax calculation: calculateTax(\"Part-time\") = $" + 
            new DecimalFormat("#,##0.00").format(emp4.calculateTax("Part-time")));
        
        // Contract employee - calculateSalary(fixedAmount) and calculateTax(contractAmount)
        System.out.println("\n3. Contract Employee (Lisa Garcia):");
        System.out.println("   Salary calculation: calculateSalary(45000.0) = $" + 
            new DecimalFormat("#,##0.00").format(emp6.calculateSalary(45000.0)));
        System.out.println("   Tax calculation: calculateTax(45000.0) = $" + 
            new DecimalFormat("#,##0.00").format(emp6.calculateTax(45000.0)));
        
        // Generate individual pay slips
        System.out.println("\n" + "=".repeat(60));
        System.out.println("INDIVIDUAL PAY SLIPS");
        System.out.println("=".repeat(60));
        
        emp1.generatePaySlip();  // Full-time
        emp4.generatePaySlip();  // Part-time
        emp6.generatePaySlip();  // Contract
        
        // Generate company-wide payroll report
        System.out.println("\n" + "=".repeat(60));
        System.out.println("COMPANY-WIDE REPORTS");
        System.out.println("=".repeat(60));
        
        Employee.generateCompanyPayrollReport();
        
        // Additional demonstration of method overloading with different parameters
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ADDITIONAL METHOD OVERLOADING EXAMPLES");
        System.out.println("=".repeat(60));
        
        System.out.println("\nTesting same method names with different parameters:");
        System.out.println("emp2.calculateSalary() [Full-time] = $" + 
            new DecimalFormat("#,##0.00").format(emp2.calculateSalary()));
        System.out.println("emp5.calculateSalary(30.0, 100) [Part-time] = $" + 
            new DecimalFormat("#,##0.00").format(emp5.calculateSalary(30.0, 100)));
        System.out.println("emp7.calculateSalary(35000.0) [Contract] = $" + 
            new DecimalFormat("#,##0.00").format(emp7.calculateSalary(35000.0)));
        
        System.out.println("\nTesting tax calculation overloading:");
        System.out.println("emp3.calculateTax() [Full-time] = $" + 
            new DecimalFormat("#,##0.00").format(emp3.calculateTax()));
        System.out.println("emp5.calculateTax(\"Part-time\") [Part-time] = $" + 
            new DecimalFormat("#,##0.00").format(emp5.calculateTax("Part-time")));
        System.out.println("emp7.calculateTax(35000.0) [Contract] = $" + 
            new DecimalFormat("#,##0.00").format(emp7.calculateTax(35000.0)));
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PAYROLL SYSTEM DEMO COMPLETED");
        System.out.println("=".repeat(60));
    }
}