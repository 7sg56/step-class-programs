// Interface
interface Payable {
    void generatePaySlip();
}

// Abstract class
abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

// Concrete class
class Manager extends Employee implements Payable {
    private String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    double calculateBonus() {
        return salary * 0.2; // 20% bonus
    }

    @Override
    public void generatePaySlip() {
        double bonus = calculateBonus();
        System.out.println("Pay Slip for Manager: " + name);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Pay: " + (salary + bonus));
    }

    public static void main(String[] args) {
        Manager mgr = new Manager("Sourish", 80000, "IT");
        mgr.generatePaySlip();
    }
}
