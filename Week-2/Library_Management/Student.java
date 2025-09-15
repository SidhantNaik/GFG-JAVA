// package Week-2.Library_Management;

import java.util.Scanner;

public class Student {

    String studentName;
    String regNum;

    // book borrowedBooks[] = new book[3];
    public int booksCount = 0;

   
    Scanner sc = new Scanner(System.in);

    public Student() {

        System.out.println("Enter Student Name:");
        this.studentName = sc.nextLine();

        System.out.println("Enter Registration Number:");
        this.regNum = sc.nextLine();
    }
}
