import java.util.Scanner;

public class Books {
    static Book bookList[] = new Book[50];
    static int bookCount = 0;

    Scanner sc = new Scanner(System.in);

    // Function to display menu options
    public void menuOptions() {
        System.out.println("1. Add New Book");
        System.out.println("2. Update Book Quantity");
        System.out.println("3. Search Books");
        System.out.println("4. Show All Books");
        System.out.println("5. Register New Student");
        System.out.println("6. Show All Registered Students");
        System.out.println("7. Check Out Book");
        System.out.println("8. Check In Book");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

    // Function to check if book already exists.
    public boolean compareBooks(Book b) {
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].serialNumber == b.serialNumber && bookList[i].bookName.equalsIgnoreCase(b.bookName))
                return false;
        }

        if (bookCount <= 50)
            return true;
        else
            System.out.println("Book limit reached");

        return true;
    }

    // Function to add new book to the list.
    public void addNewBook(Book b) {
        bookList[bookCount] = b;
        bookCount++;
    }

    // Fuction to Search book by Serial Number.
    public void searchBookBySerial() {
        System.out.println("Enter Serial Number of Book to be searched:");
        int serial = sc.nextInt();

        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].serialNumber == serial) {
                System.out.println("Book Found!");
                System.out.println("Serial Number: " + bookList[i].serialNumber);
                System.out.println("Book Name: " + bookList[i].bookName);
                System.out.println("Author Name: " + bookList[i].authorName);
                System.out.println("Available Quantity: " + bookList[i].bookQty);
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // Fuction to search by author name.
    public void searchBookByAuthor() {
        System.out.println("Enter Author Name of Book to be searched:");
        String author = sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].authorName.equalsIgnoreCase(author)) {
                System.out.println("Book Found!");
                System.out.println("Serial Number: " + bookList[i].serialNumber);
                System.out.println("Book Name: " + bookList[i].bookName);
                System.out.println("Author Name: " + bookList[i].authorName);
                System.out.println("Available Quantity: " + bookList[i].bookQty);
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // Function to display all books.
    public static void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("No Books Available!");
            return;
        }

        System.out.println("Books Available:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Serial Number: " + bookList[i].serialNumber);
            System.out.println("Book Name: " + bookList[i].bookName);
            System.out.println("Author Name: " + bookList[i].authorName);
            System.out.println("Available Quantity: " + bookList[i].bookQty);
            System.out.println("---------------------------");
        }
    }

    // Function to update book quantity.
    public void updateBookQty() {
        System.out.println("Enter Serial Number of Book to update quantity:");
        int serial = sc.nextInt();

        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].serialNumber == serial) {
                System.out.println("Enter new quantity:");
                int qty = sc.nextInt();
                bookList[i].bookQty = qty;
                System.out.println("Book Quantity Updated!");
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // function to delete a book.
    public void deleteBook() {
        System.out.println("Enter Serial Number of Book to be deleted:");
        int serial = sc.nextInt();

        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].serialNumber == serial) {
                for (int j = i; j < bookCount - 1; j++) {
                    bookList[j] = bookList[j + 1];
                }
                bookList[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book Deleted!");
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // function to check availability of book
    public int isAvailable(int sNo) {

        for (int i = 0; i < bookCount; i++) {
            if (sNo == bookList[i].serialNumber) {
                if (bookList[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Available in Library.");
        return -1;
    }

    // Function to check out the book
    public Book checkOutBook() {

        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sNo = sc.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            bookList[bookIndex].bookQtyCopy--;
            return bookList[bookIndex];
        }
        return null;
    }

    // To add the Book to the Library
    public void checkInBook(Book b) {
        for (int i = 0; i < bookCount; i++) {
            if (b.equals(bookList[i])) {
                bookList[i].bookQtyCopy++;
                return;
            }
        }
    }
}
