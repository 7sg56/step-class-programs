// File: LibraryTest.java
public class LibraryTest {
    public static void main(String[] args) {
        Library cityLibrary = new Library("City Central Library");
        Book book1 = new Book("The Java Standard" , "J. Gosling" , "100-101");
        Book book2 = new Book("OOP Fundamentals" , "A. Smith" , "200-202");
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);
        Member memberA = new Member("Riya Sharma");
        memberA.borrowBook(book1);
        cityLibrary.listAllBooks();
        memberA.listBorrowed();
    }
}
