public class Book {
    private String title;
    private boolean available;

    public Book(String title) {
        this.title = title;
        this.available = true; 
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
        } else {
            throw new IllegalStateException("This book has been borrowed.");
        }
    }

    public void returnBook() {
        available = true;
    }
}
