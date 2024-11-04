import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;
    ArrayList<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        member.borrowBook(book);
    }

    public void returnBook(LibraryMember member) {
        member.returnBook();
    }

    public void displayBooks() {
        System.out.println("Book list:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Status: " + (book.isAvailable() ? "Available" : "Not available"));
        }
    }
}
