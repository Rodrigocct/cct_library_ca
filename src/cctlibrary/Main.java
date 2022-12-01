/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary;

import cctlibrary.data.Books;
import cctlibrary.data.Borrowings;
import cctlibrary.data.Reservations;
import cctlibrary.data.Students;
import cctlibrary.entities.Book;
import cctlibrary.entities.Borrowing;
import cctlibrary.entities.Reservation;
import cctlibrary.entities.Student;
import cctlibrary.enums.BookSearchEnum;
import cctlibrary.enums.BorrowingSearchEnum;
import cctlibrary.enums.ConfirmEnum;
import cctlibrary.enums.StudentSearchEnum;
import cctlibrary.utils.InputUtilities;
import cctlibrary.utils.MySearchingUtils;
import cctlibrary.utils.MySortingUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rodrigo & anastasiia
 */
public class Main {

    
   //defines variables that we use accross the proyect
    private Books books;
    private Students students;
    private Borrowings borrowings;
    private Reservations reservations;

    InputUtilities myInput = new InputUtilities();
    MySortingUtils mySortUtil = new MySortingUtils();
    MySearchingUtils mySearchUtil = new MySearchingUtils();

    Book[] bookToArray;
    Student[] studentToArray;

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        new Main();
    }
//constructor
    public Main() {
        loadDatabase();
        init();
    }

    public void init() {

        // This is the main menu.
        int listOption;
        //the variable exitOption is to control the loop while, it won't finish unless the user imput is 7  (EXIT)
        boolean exitOption = false;
        while (!exitOption) {
            try {

                Scanner s = new Scanner(System.in);
                System.out.println("");
                System.out.println("   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ MENU SYSTEM $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("1) Search for a specific book by title or author name");
                System.out.println("2) List all books by title or author name in alphabetical order");
                System.out.println("3) Search for a specific student by name or ID");
                System.out.println("4) List all students by alphabetical name or ID order");
                System.out.println("5) Borrowing a book");
                System.out.println("6) For a specific student, list the books that they have borrowed");
                System.out.println("7) Exit");
                System.out.println("   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.print("Select option --> ");

                listOption = s.nextInt();

                switch (listOption) {
                    case 1:
                        System.out.println("------------------------------------------");
                        System.out.println("Search a book by title or author name");
                        System.out.println("------------------------------------------");
                  //the method bookSearch is called
                        bookSearch();
                        enterKey();
                        break;
                    case 2:
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("List all books by title or author name alphabetical order");
                        System.out.println("-------------------------------------------------------------");

                        listBooks();
                        enterKey();
                        break;

                    case 3:
                        System.out.println("-----------------------------------------------");
                        System.out.println("Search for a specific student by name or ID");
                        System.out.println("-----------------------------------------------");

                        searchStudents();
                        enterKey();
                        break;

                    case 4:
                        System.out.println("------------------------------------------------------");
                        System.out.println("List all students by alphabetical name or ID order");
                        System.out.println("------------------------------------------------------");

                        listStudents();
                        enterKey();
                        break;

                    case 5:
                        System.out.println("----------------");
                        System.out.println("Borrowing a book");
                        System.out.println("----------------");

                        borrowingBooks();
                        enterKey();
                        break;

                    case 6:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("For a specific student, list the books that they have borrowed");
                        System.out.println("--------------------------------------------------------------");

                        listBooksBorrowed();
                        enterKey();
                        break;

                    case 7:
                        System.out.println("Good Bye!!");
                        exitOption = true;
                        break;

                    default:
                        System.out.println("Selected option doesn't exist");
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("*** Selected option is incorrect ***");
            }
        }
    }
//to load the data that is stored in the entities
    public void loadDatabase() {
        books = new Books();
        books.loadData();

        students = new Students();
        students.loadData();

        borrowings = new Borrowings();
        borrowings.loadData();

        reservations = new Reservations();
        reservations.loadData();
    }

    public void enterKey() {
        myInput.getUserText("Please imput any number to display Menu... ");
    }

    public void bookSearch() {
        
        // before search, print the options first,
        System.out.println(BookSearchEnum.listAllOptions());
        // user is expected to select their option
        int bookSearchOption = myInput.getUserInt("Select option --> ", 1, BookSearchEnum.values().length);
        switch (bookSearchOption) {
            case 1:
                String authorname = myInput.getUserText("Input Author full name --> ");
                int linearSearchBook = mySearchUtil.linearSearchBookByAuthor(books.getFileData(), authorname);
                if (linearSearchBook > -1) {
                    System.out.println("Book match with --> " + books.getFileData().get(linearSearchBook).toString());
                } else {
                    System.out.println("No Book match for author --> " + authorname);
                }
                break;
            case 2:
                String title = myInput.getUserText("Input title --> ");
                ArrayList<Book> booksByTitle = mySearchUtil.linearSearchBookByTitle(books.getFileData(), title);
                if (!booksByTitle.isEmpty()) {
                    System.out.println("Book(s) match(s) for title --> " + title);
                    booksByTitle.forEach((b) -> {
                        System.out.println(b);
                    });
                } else {
                    System.out.println("No Book match for title --> " + title);
                }
                break;
            default:
                // If the selected option does not correspond to any of the list
                System.out.println("Incorrect Option");
                break;
        }
    }

    public void listBooks() {

        bookToArray = books.getFileData().toArray(new Book[books.getFileData().size()]);

        // before to do the search the options is printed
        System.out.println(BookSearchEnum.listAllOptions());
        // The user is expected to imput one option
        int bookSortOption = myInput.getUserInt("Select option --> ", 1, BookSearchEnum.values().length);
        switch (bookSortOption) {
            case 1:
                mySortUtil.bubbleSortByBookAuthor(bookToArray);
                break;
            case 2:
                mySortUtil.bubbleSortByBookTitle(bookToArray);
                break;
            default:
                // If the selected option does not correspond to any of the list
                System.out.println("Incorrect Option");
                break;
        }
        for (int i = 0; i < bookToArray.length; i++) {
            System.out.println(bookToArray[i].toString());
        }
    }

    public void searchStudents() {

        // print the options
        System.out.println(StudentSearchEnum.listAllOptions());
        // the user is expected to enter an option
        int studentSearchOption = myInput.getUserInt("Select option --> ", 1, StudentSearchEnum.values().length);
        switch (studentSearchOption) {
            case 1:
                String studentName = myInput.getUserText("Input Student's Full Name --> ");
                int linearSearchStudent = mySearchUtil.linearSearchStudentByName(students.getFileData(), studentName);
                if (linearSearchStudent > -1) {
                    System.out.println("Student match with --> " + students.getFileData().get(linearSearchStudent).toString());
                } else {
                    System.out.println("No Student match for name --> " + studentName);
                }
                break;
            case 2:
                int studentId = myInput.getUserInt("Input Student's id --> ", 1);
                sortStudents();

                int studentById = mySearchUtil.binarySearch(students.getFileData(), studentId);
                if (studentById > -1) {
                    System.out.println("Student match for id --> " + students.getFileData().get(studentById).toString());
                } else {
                    System.out.println("No Student match for id --> " + studentById);
                }

                break;
            default:
                // If the selected option does not correspond to any of the list
                System.out.println("Incorrect Option");
                break;
        }
    }

    public void listStudents() {

        studentToArray = students.getFileData().toArray(new Student[students.getFileData().size()]);

       
        System.out.println(StudentSearchEnum.listAllOptions());
       
        int studentSortOption = myInput.getUserInt("Select option --> ", 1, StudentSearchEnum.values().length);
        switch (studentSortOption) {
            case 1:
                mySortUtil.bubbleSortByStudentName(studentToArray);
                break;
            case 2:
                mySortUtil.mergeSortStudentById(studentToArray, 0, studentToArray.length - 1);
                break;
            default:
                
                System.out.println("Incorrect Option");
                break;
        }
        for (int i = 0; i < studentToArray.length; i++) {
            System.out.println(studentToArray[i].toString());
        }
    }

    public void borrowingBooks() {
       
        System.out.println(BorrowingSearchEnum.listAllOptions());
        
        int borrowingSearchOption = myInput.getUserInt("Select option --> ", 1, BorrowingSearchEnum.values().length);
        switch (borrowingSearchOption) {
            case 1:
                Borrowing registerBorrowing = new Borrowing();
                String authorname = myInput.getUserText("Input Author Full Name --> ");
                int linearSearchBook = mySearchUtil.linearSearchBookByAuthor(books.getFileData(), authorname);
                if (linearSearchBook > -1) {

                    Book bBook = books.getFileData().get(linearSearchBook);
                    System.out.println("[Book match]" + books.getFileData().get(linearSearchBook).toString());
                    registerBorrowing.setBookId(bBook.getId());

                    int studentId = myInput.getUserInt("Input Student id --> ", 1);
                    sortStudents();

                    int studentById = mySearchUtil.binarySearch(students.getFileData(), studentId);
                    if (studentById > -1) {
                        Student bStudent = students.getFileData().get(studentById);
                        System.out.println("[Student] " + students.getFileData().get(studentById).toString());
                        registerBorrowing.setStudentId(bStudent.getId());
                        boolean hasBorrowing = false;
                        for (Borrowing b : borrowings.getFileData()) {
                            if (b.getBookId().equals(registerBorrowing.getBookId())) {
                                hasBorrowing = true;
                                break;
                            }
                        }
                        if (hasBorrowing) {
                            System.out.println("The book is borrowed. Do you want to make a reservation?");
                            System.out.println(ConfirmEnum.listAllOptions());
                            int confirmEnum = myInput.getUserInt("Select option --> ", 1, ConfirmEnum.values().length);
                            switch (confirmEnum) {
                                case 1:
                                    Reservation res = new Reservation();
                                    res.setBookId(registerBorrowing.getBookId());
                                    res.getStudents().Enqueue(String.valueOf(registerBorrowing.getStudentId()));
                                    boolean bookexist = false;
                                    for (Reservation r : reservations.getFileData()) {
                                        if (r.getBookId().equals(res.getBookId())) {
                                            boolean studentReservationExist = false;
                                            for (int i = 0; i < r.getStudents().size(); i++) {
                                                if (r.getStudents().getData()[i].equals(String.valueOf(registerBorrowing.getStudentId()))) {
                                                    studentReservationExist = true;
                                                    System.out.println("The book has already been reserved by the same student");
                                                    break;
                                                }
                                            }
                                            if (!studentReservationExist) {
                                                r.getStudents().Enqueue(String.valueOf(registerBorrowing.getStudentId()));
                                                System.out.println("The reservation has been confirmed");
                                            }
                                            bookexist = true;
                                            break;
                                        }
                                    }
                                    if (!bookexist) {
                                        reservations.getFileData().add(res);
                                        System.out.println("The reservation has been confirmed");
                                    }
                                    reservations.saveData();
                                    break;
                                case 2:
                                    System.out.println("The reservation has been canceled");
                                    break;
                                default:
                                    // If the selected option does not correspond to any of the list
                                    System.out.println("Incorrect Option");
                                    break;
                            }
                        } else {
                            borrowings.getFileData().add(registerBorrowing);
                            borrowings.saveData();
                            System.out.println("The borrowing has been registered");
                        }
                    } else {
                        System.out.println("No Student match for id --> " + studentById + " Can't register a borrowing");
                    }
                } else {
                    System.out.println("No Book match for author --> " + authorname + " Can't register a borrowing");
                }
                break;
            case 2:
                String returnAuthorName = myInput.getUserText("Input Author Full Name --> ");
                int returnBookSearch = mySearchUtil.linearSearchBookByAuthor(books.getFileData(), returnAuthorName);
                if (returnBookSearch > -1) {
                    Book bok = books.getFileData().get(returnBookSearch);
                    System.out.println("Return Book --> " + bok.toString());
                    Borrowing aux = null;
                    for (Borrowing b : borrowings.getFileData()) {
                        if (b.getBookId().equals(bok.getId())) {
                            aux = b;
                            break;
                        }
                    }

                    if (aux != null) {
                        for (Reservation r : reservations.getFileData()) {
                            if (r.getBookId().equals(aux.getBookId())) {
                                String studentId = r.getStudents().First();
                                sortStudents();

                                int studentById = mySearchUtil.binarySearch(students.getFileData(), Integer.valueOf(studentId));
                                if (studentById > -1) {
                                    System.out.println("The next student waiting for that book --> " + students.getFileData().get(studentById).toString());
                                } else {
                                    System.out.println("No Student match for id --> " + studentById);
                                }

                            }
                        }
                        borrowings.getFileData().remove(aux);
                        borrowings.saveData();
                    }
                } else {
                    System.out.println("No Book match for author --> " + returnAuthorName);
                }

                break;
            default:
                // If the selected option does not correspond to any of the list
                System.out.println("Incorrect Option");
                break;
        }
    }

    public void listBooksBorrowed() {
        int studentId = myInput.getUserInt("Input Student id --> ", 1);
        sortStudents();

        int studentById = mySearchUtil.binarySearch(students.getFileData(), studentId);
        if (studentById > -1) {
            for (Borrowing bx : borrowings.getFileData()) {
                if (bx.getStudentId() == studentId) {
                    System.out.println("Book borroweb by student --> " + students.getFileData().get(studentById).getFirstname()+" "+students.getFileData().get(studentById).getSurname());
                    for (Book bk : books.getFileData()) {
                        if (bx.getBookId().equals(bk.getId())) {
                            System.out.println(bk.getBookTitle());
                        }
                    }

                }
            }
        } else {
            System.out.println("No Student match for id --> " + studentById);
        }
    }
    
    public void sortStudents(){
        studentToArray = students.getFileData().toArray(new Student[students.getFileData().size()]);
        mySortUtil.mergeSortStudentById(studentToArray, 0, studentToArray.length - 1);
        students.setFileData(new ArrayList<>(Arrays.asList(studentToArray)));    
    }
}
