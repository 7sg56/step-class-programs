/**
 * Book class for Library cloning demonstration
 */
public class Book implements Cloneable {
    private String title;
    private String author;
    private int pages;
    
    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    
    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
    
    // Override clone() for Book
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
