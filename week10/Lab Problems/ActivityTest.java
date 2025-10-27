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
} else {
System.out.println("[Admin] Data approved. Sending confirmation request.");
System.out.println("[Admin] Data needs correction. Returning to student.");
}
}
}
public class ActivityTest {
public static void main(String[] args) {
Student s = new Student();
SystemValidator v = new SystemValidator();
Admin a = new Admin();
boolean formFilled = s.fillForm("Ravi Sharma, Valid Documents"); // Step 1
boolean isValid = v.validate(formFilled); // Step 2
// Step 3 (Decision) handled here implicitly
if (isValid) {
a.approve(true); // Step 4
// Step 5
System.out.println("[System] Registration Confirmation Sent. (End)");
} else {
a.approve(false);
}
}
}