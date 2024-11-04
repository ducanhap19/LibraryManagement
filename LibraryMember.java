public class LibraryMember {
    private String memberName;
    private Book borrowedBook;

    public LibraryMember(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBook = book;
        } else {
            throw new IllegalStateException("This book is not available.");
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            borrowedBook = null;
        } else {
            throw new IllegalStateException("You have not borrowed any books.");
        }
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }
}
