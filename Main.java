import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new book");
            System.out.println("2. Add new member");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Books list");
            System.out.println("6. Out");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Input book title: ");
                    String title = scanner.nextLine();
                    library.addBook(new Book(title));
                    System.out.println("Added book.");
                    break;
                case 2:
                    System.out.print("Input member name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(new LibraryMember(memberName));
                    System.out.println("Added member.");
                    break;
                case 3:
                    System.out.print("Input member name: ");
                    String memberNameForBorrow = scanner.nextLine();
                    LibraryMember memberToBorrow = findMember(library, memberNameForBorrow);
                    if (memberToBorrow != null) {
                        System.out.print("Input book title you want to borrow: ");
                        String bookTitleToBorrow = scanner.nextLine();
                        Book bookToBorrow = findBook(library, bookTitleToBorrow);
                        if (bookToBorrow != null) {
                            try {
                                library.borrowBook(memberToBorrow, bookToBorrow);
                                System.out.println("You have successfully borrowed the book.");
                            } catch (IllegalStateException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("This book does not exist.");
                        }
                    } else {
                        System.out.println("This member does not exist.");
                    }
                    break;
                case 4:
                    System.out.print("Input member name: ");
                    String memberNameForReturn = scanner.nextLine();
                    LibraryMember memberToReturn = findMember(library, memberNameForReturn);
                    if (memberToReturn != null) {
                        try {
                            memberToReturn.returnBook();
                            System.out.println("You have successfully returned the book.");
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("This member does not exist.");
                    }
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Out.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option not match. Please choose again.");
            }
        }
    }

    private static LibraryMember findMember(Library library, String memberName) {
        for (LibraryMember member : library.members) {
            if (member.getMemberName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null;
    }

    private static Book findBook(Library library, String title) {
        for (Book book : library.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
