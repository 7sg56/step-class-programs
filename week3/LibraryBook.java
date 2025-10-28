class Book {
    // Instance variables (Private)
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Static variables for tracking total books and available books
    private static int totalBooks = 0;
    private static int availableBooks = 0;

    // Constructor to initialize Book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = generateBookId();
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    // Method to issue the book (change availability status)
    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is not available.");
        }
    }

    // Method to return the book (change availability status)
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("The book '" + title + "' is already available in the library.");
        }
    }

    // Method to display book information
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Issued"));
        System.out.println("----------------------------");
    }

    // Static method to generate unique book ID
    private static String generateBookId() {
        return "B" + String.format("%03d", totalBooks);  // e.g., "B001", "B002"
    }

    // Static methods to get total and available books
    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }

    // Getters for Book details
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Member {
    // Instance variables (Private)
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    // Constructor to initialize Member details
    public Member(String memberName) {
        this.memberName = memberName;
        this.memberId = generateMemberId();
        this.booksIssued = new String[5];  // Assuming a member can issue up to 5 books
        this.bookCount = 0;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book != null && book.isAvailable()) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId(); // Store book ID in the member's issued list
            System.out.println(memberName + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println(memberName + " cannot borrow the book: " + book.getTitle() + " (either not available or invalid).");
        }
    }

    // Method to return a book
    public void returnBook(String bookId, Book[] books) {
        boolean found = false;
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i] != null && booksIssued[i].equals(bookId)) {
                found = true;
                booksIssued[i] = null; // Remove book from issued list
                bookCount--;
                // Return the book object using bookId
                for (Book book : books) {
                    if (book.getBookId().equals(bookId)) {
                        book.returnBook();
                        break;
                    }
                }
                System.out.println(memberName + " returned the book with ID: " + bookId);
                break;
            }
        }
        if (!found) {
            System.out.println(memberName + " has not borrowed the book with ID: " + bookId);
        }
    }

    // Static method to generate unique member ID
    private static String generateMemberId() {
        return "M" + String.format("%03d", (int) (Math.random() * 1000));  // e.g., "M001", "M002"
    }

    // Method to display member information
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Books Issued: ");
        if (bookCount > 0) {
            for (int i = 0; i < bookCount; i++) {
                System.out.println(booksIssued[i]);
            }
        } else {
            System.out.println("No books issued.");
        }
        System.out.println("----------------------------");
    }

    // Getters for member ID and issued book count
    public String getMemberId() {
        return memberId;
    }

    public String[] getBooksIssued() {
        return booksIssued;
    }
}

public class LibraryBook {
    public static void main(String[] args) {
        // Creating Book objects
        Book[] books = new Book[3];
        books[0] = new Book("To Kill a Mockingbird", "Harper Lee");
        books[1] = new Book("1984", "George Orwell");
        books[2] = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Display initial book info
        System.out.println("Initial Book Details:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        // Creating Member objects
        Member[] members = new Member[2];
        members[0] = new Member("John Doe");
        members[1] = new Member("Jane Smith");

        // Display initial member info
        System.out.println("\nInitial Member Details:");
        for (Member member : members) {
            member.displayMemberInfo();
        }

        // Borrowing books
        System.out.println("\nJohn borrows '1984':");
        members[0].borrowBook(books[1]);

        // Trying to borrow the same book again (should fail)
        System.out.println("\nJane tries to borrow '1984' again:");
        members[1].borrowBook(books[1]);

        // Returning books
        System.out.println("\nJohn returns '1984':");
        members[0].returnBook(books[1].getBookId(), books);

        // Borrowing again after return
        System.out.println("\nJane borrows '1984' after John returns it:");
        members[1].borrowBook(books[1]);

        // Display final book info
        System.out.println("\nFinal Book Details:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        // Display final member info
        System.out.println("\nFinal Member Details:");
        for (Member member : members) {
            member.displayMemberInfo();
        }

        // Display library statistics
        System.out.println("\nLibrary Statistics:");
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}
