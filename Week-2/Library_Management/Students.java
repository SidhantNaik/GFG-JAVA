import java.util.Scanner;

public class Students {

    Scanner sc = new Scanner(System.in);
    Student[] studentList = new Student[50];
    static int studentCount = 0;

    // Function to add new Student.
    void addNewStudent(Student s) {
        for (int i = 0; i < studentCount; i++) {
            if (s.regNum == studentList[i].regNum) {
                System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }
        }

        if (studentCount <= 50) {
            studentList[studentCount] = s;
            studentCount++;
        }
    }

    // Function to show all Student.
    public void showAllStudent() {
        if (studentCount <= 0)
            System.out.println("No Student Data is available.");

        for (int i = 0; i < studentCount; i++)
            System.out.println("Student Reg. No. : " + studentList[i].regNum + "Name : " + studentList[i].studentName);
    }

    // Function to check student.
    public int isStudentRegistered() {
        System.out.println("Enter Student Reg. No. :");
        String regNo = sc.nextLine();

        for (int i = 0; i < studentCount; i++)
            if (regNo.equalsIgnoreCase(studentList[i].regNum))
                return 1;

        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
        return -1;
    }

    public void checkOutBook(Books book)
    {
        int studentIndex = isStudentRegistered();

        if (studentIndex != -1) {
            System.out.println("checking out");

            Books.displayAllBooks();
            Book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {
                if (studentList[studentIndex].booksCount<= 3) {
                    System.out.println("adding book");

                    studentList[studentIndex].borrowedBooks[studentList[studentIndex].booksCount]= b;
                    studentList[studentIndex].booksCount++;

                    return;
                }
                else {
                    System.out.println("Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    // To add the book
    public void checkInBook(Books book) {
        int studentIndex = this.isStudentRegistered();
        if (studentIndex != -1) {

            System.out.println( "S.No\t\t\tBook Name\t\t\tAuthor Name");

            Student s = studentList[studentIndex];

            for (int i = 0; i < s.booksCount; i++) 
                System.out.println(s.borrowedBooks[i].serialNumber + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            

            System.out.println("Enter Serial Number of Book to be Checked In:");

            int sNo = sc.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].serialNumber) {
                    
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo+ "not Found");
        }
    }
}