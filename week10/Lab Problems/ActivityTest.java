class Student {
    public boolean fillForm(String data) {
        System.out.println("[Student] Filling form with data: " + data);
        return data.contains("Valid"); // Simulating form completion
    }
}

class SystemValidator {
    public boolean validate(boolean isFilled) {
        if (!isFilled) return false;
        System.out.println("[System] Validating submitted data...");
        return Math.random() > 0.3; // 70% chance of success
    }
}

class Admin {
    public void approve(boolean isValid) {
        if (isValid) {
            System.out.println("[Admin] Data approved. Sending confirmation request.");
        } else {
            System.out.println("[Admin] Data needs correction. Returning to student.");
        }
    }
}

public class ActivityTest {
    public static void main(String[] args) {
        Student s = new Student();
        SystemValidator v = new SystemValidator();
        Admin a = new Admin();
        
        // Step 1: Student fills form
        boolean formFilled = s.fillForm("Ravi Sharma, Valid Documents");
        
        // Step 2: System validates data
        boolean isValid = v.validate(formFilled);
        
        // Step 3: Decision point (handled implicitly)
        if (isValid) {
            // Step 4: Admin approves
            a.approve(true);
            // Step 5: System generates confirmation
            System.out.println("[System] Registration Confirmation Sent. (End)");
        } else {
            // Step 3: Invalid data - return to student
            a.approve(false);
            System.out.println("[System] Returning to Step 1 for correction.");
        }
    }
}