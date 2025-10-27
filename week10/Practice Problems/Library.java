import java.util.ArrayList;
import java.util.List;

// File: Library.java (Composition: Library owns Books)
class Library {
    private String name;
    private List<Book> books;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Library '" + name + "' added: " + book.getTitle());
    }
    
    public void listAllBooks() {
        System.out.println("\n--- Books in " + name + " ---");
        for (Book book : books) { 
            book.showDetails(); 
        }
    }
}
