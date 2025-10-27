import java.util.ArrayList;
import java.util.List;
class Book {
private String title;
private String isbn;
public Book(String title, String isbn) {
this.title = title; this.isbn = isbn;
}
public String getDetails() {
return "Book: " + title + " (ISBN: " + isbn + ")";
}
}
class Member {
private int memberId;
private String name;
private List<Book> borrowedBooks = new ArrayList<>();
public Member(int id, String name) {
this.memberId = id; this.name = name;
}
public void borrowBook(Book book) {
borrowedBooks.add(book);
System.out.println(name + " borrowed: " + book.getDetails());
}
public void listBorrowed() {
System.out.println(" --- " + name + " has " + borrowedBooks.size() + " book(s) borrowed.");
}
}
class Librarian {
private int empId;
private String shift;
public Librarian(int id, String shift) {
this.empId = id; this.shift = shift;
}
public void manageBook(Book book) {
System.out.println("Librarian " + empId + " (" + shift + ") is managing: " + book.title);
}
}
public class LibraryTest {
public static void main(String[] args) {
Book b1 = new Book("Java OOP" , "101");
Book b2 = new Book("UML Basics" , "102");
Member m1 = new Member(50, "Priya Sharma");
Librarian l1 = new Librarian(1, "Day");
l1.manageBook(b1); // Librarian-Book Association
m1.borrowBook(b1); // Member-Book Association
m1.borrowBook(b2);
m1.listBorrowed();
}
}