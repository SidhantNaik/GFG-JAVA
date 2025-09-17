import java.util.Scanner;


public class Books {
    Book bookList[] = new Book[50];
    int bookCount = 0;

    Scanner sc = new Scanner(System.in);

    // Function to check if book already exists.
    public boolean compareBooks(Book b){
       for(int i=0; i<bookCount; i++){
            if(bookList[i].serialNumber == b.serialNumber && bookList[i].bookName.equalsIgnoreCase(b.bookName))
                return false;
        }

        if(bookCount <= 50) return true;
        else System.out.println("Book limit reached");
        
        return true;
    }

    // Function to add new book to the list.
    public void addNewBook(Book b){
        bookList[bookCount] = b;
        bookCount++;
    }

    // Fuction to Search book by Serial Number.
    public void searchBookBySerial(){
        System.out.println("Enter Serial Number of Book to be searched:");
        int serial = sc.nextInt();

        for(int i=0; i<bookCount; i++){
            if(bookList[i].serialNumber == serial){
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
    public void searchBookByAuthor(){
        System.out.println("Enter Author Name of Book to be searched:");
        String author = sc.nextLine();

        for(int i=0; i<bookCount; i++){
            if(bookList[i].authorName.equalsIgnoreCase(author)){
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
    public void displayAllBooks(){
        if(bookCount == 0){
            System.out.println("No Books Available!");
            return;
        }

        System.out.println("Books Available:");
        for(int i=0; i<bookCount; i++){
            System.out.println("Serial Number: " + bookList[i].serialNumber);
            System.out.println("Book Name: " + bookList[i].bookName);
            System.out.println("Author Name: " + bookList[i].authorName);
            System.out.println("Available Quantity: " + bookList[i].bookQty);
            System.out.println("---------------------------");
        }
    }
}
