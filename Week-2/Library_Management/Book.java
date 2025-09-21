
// package Week-2.Library_Management;
import java.util.Scanner;

public class Book {

    int serialNumber, bookQty, bookQtyCopy;
    String bookName, authorName;

    Scanner sc = new Scanner(System.in);

    Book() {
        
        System.out.println("Enter Serial No of Book:");
        this.serialNumber = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter Book Name:");
        this.bookName = sc.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = sc.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = sc.nextInt();
        this.bookQtyCopy = this.bookQty;
    }
}
