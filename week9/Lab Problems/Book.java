/**
 * LAB PROBLEM 1: Comparing Objects Using equals() and ==
 * Topic: Object Class Methods – equals() vs ==
 * 
 * Create a Book class with title and author fields. Override the equals() method to
 * compare two books based on their title and author. Demonstrate the difference between == and
 * .equals() using two Book objects.
 */

public class Book {
    private String title;
    private String author;
    
    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    // Override equals() method for content comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
    
    // Override toString() for better representation
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
    
    // Main method to demonstrate == vs equals()
    public static void main(String[] args) {
        // Create two books with same content
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Java Programming", "John Doe");
        Book book3 = book1; // Same reference
        
        System.out.println("=== LAB PROBLEM 1: equals() vs == ===");
        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3);
        System.out.println();
        
        // Demonstrate == (reference comparison)
        System.out.println("Reference comparison (==):");
        System.out.println("book1 == book2: " + (book1 == book2)); // false - different references
        System.out.println("book1 == book3: " + (book1 == book3)); // true - same reference
        System.out.println();
        
        // Demonstrate equals() (content comparison)
        System.out.println("Content comparison (.equals()):");
        System.out.println("book1.equals(book2): " + book1.equals(book2)); // true - same content
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // true - same content
        System.out.println();
        
        // Demonstrate with different content
        Book book4 = new Book("Python Programming", "Jane Smith");
        System.out.println("Book 4: " + book4);
        System.out.println("book1.equals(book4): " + book1.equals(book4)); // false - different content
    }
}
