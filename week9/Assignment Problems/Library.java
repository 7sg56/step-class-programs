import java.util.ArrayList;
import java.util.List;

/**
 * Topic 4: Deep vs Shallow Cloning of Objects
 * Library class demonstrating shallow and deep cloning
 */
public class Library implements Cloneable {
    private String libraryName;
    private List<Book> books;
    
    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getLibraryName() { return libraryName; }
    public void setLibraryName(String libraryName) { this.libraryName = libraryName; }
    
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
    
    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }
    
    // Shallow clone - only copies object references
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        // This is shallow cloning - the books list is shared between original and clone
        return clonedLibrary;
    }
    
    // Deep clone - copies the entire list with individual book data
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLibrary = new Library(this.libraryName);
        
        // Deep clone each book in the list
        for (Book book : this.books) {
            Book clonedBook = (Book) book.clone();
            clonedLibrary.addBook(clonedBook);
        }
        
        return clonedLibrary;
    }
    
    // Override toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library{name='").append(libraryName).append("', books=[");
        for (int i = 0; i < books.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(books.get(i));
        }
        sb.append("]}");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        try {
            // Create original library with books
            Library originalLibrary = new Library("Central Library");
            originalLibrary.addBook(new Book("Java Programming", "John Doe", 500));
            originalLibrary.addBook(new Book("Data Structures", "Jane Smith", 400));
            originalLibrary.addBook(new Book("Algorithms", "Bob Johnson", 600));
            
            System.out.println("=== Original Library ===");
            System.out.println(originalLibrary);
            
            // Shallow cloning demonstration
            System.out.println("\n=== Shallow Cloning ===");
            Library shallowClone = (Library) originalLibrary.clone();
            System.out.println("Shallow clone created: " + shallowClone);
            
            // Modify a book in the shallow clone
            if (!shallowClone.getBooks().isEmpty()) {
                Book firstBook = shallowClone.getBooks().get(0);
                firstBook.setTitle("Modified Java Programming");
                firstBook.setPages(550);
            }
            
            System.out.println("\nAfter modifying first book in shallow clone:");
            System.out.println("Original library: " + originalLibrary);
            System.out.println("Shallow clone: " + shallowClone);
            System.out.println("Notice: Both libraries show the same modified book!");
            
            // Deep cloning demonstration
            System.out.println("\n=== Deep Cloning ===");
            Library deepClone = originalLibrary.deepClone();
            System.out.println("Deep clone created: " + deepClone);
            
            // Modify a book in the deep clone
            if (!deepClone.getBooks().isEmpty()) {
                Book firstBook = deepClone.getBooks().get(0);
                firstBook.setTitle("Deep Cloned Java Programming");
                firstBook.setPages(600);
            }
            
            System.out.println("\nAfter modifying first book in deep clone:");
            System.out.println("Original library: " + originalLibrary);
            System.out.println("Deep clone: " + deepClone);
            System.out.println("Notice: Only the deep clone shows the modified book!");
            
            // Demonstrate reference vs content
            System.out.println("\n=== Reference Analysis ===");
            System.out.println("Original == Shallow Clone: " + (originalLibrary == shallowClone));
            System.out.println("Original == Deep Clone: " + (originalLibrary == deepClone));
            System.out.println("Shallow Clone == Deep Clone: " + (shallowClone == deepClone));
            
            // Check if book references are shared
            if (!originalLibrary.getBooks().isEmpty() && !shallowClone.getBooks().isEmpty()) {
                System.out.println("Original first book == Shallow clone first book: " + 
                    (originalLibrary.getBooks().get(0) == shallowClone.getBooks().get(0)));
            }
            
            if (!originalLibrary.getBooks().isEmpty() && !deepClone.getBooks().isEmpty()) {
                System.out.println("Original first book == Deep clone first book: " + 
                    (originalLibrary.getBooks().get(0) == deepClone.getBooks().get(0)));
            }
            
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not supported: " + e.getMessage());
        }
    }
}
