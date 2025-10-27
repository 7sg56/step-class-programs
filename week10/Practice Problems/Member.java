import java.util.ArrayList;
import java.util.List;

// File: Member.java (Association: Member borrows Books)
class Member {
    private String name;
    private List<Book> borrowedBooks;
    
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed: " + book.getTitle());
    }
    
    public void listBorrowed() {
        System.out.println("- " + name + " borrowed " + borrowedBooks.size() + " books.");
    }
}
