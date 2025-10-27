import java.util.Arrays;
import java.util.List;
class Student {
private String name;
private int rollNo;
public Student(String name, int rollNo) {
this.name = name; this.rollNo = rollNo;
}
@Override
public String toString() {
return name + " (Roll: " + rollNo + ")";
}
}
class Teacher {
private String name;
private String subject;
private List<Student> guidedStudents;
public Teacher(String name, String subject, List<Student> students) {
this.name = name;
this.subject = subject;
this.guidedStudents = students; // Runtime link establishment
}
public void displayGuidedStudents() {
System.out.println("Teacher: " + name + " (" + subject + ")");
System.out.println("Guides: " + guidedStudents);
}
}
public class ObjectDiagramTest {
public static void main(String[] args) {
// Instantiate Objects
Student student1 = new Student("Ravi" , 101);
Student student2 = new Student("Neha" , 102);
Teacher teacher1 = new Teacher("Mr. Karthik" , "Java" , Arrays.asList(student1,
student2));
// Show runtime links
teacher1.displayGuidedStudents();
}
}