package pkg_Main;

import pkg_Exception.Book_Not_Found_Exception;
import pkg_Exception.Student_Not_Found_Exception;
import pkg_book.Book;
import pkg_book.Book_Manager;
import pkg_person.Student_Manager;
import pkg_person.student;
import pkg_transaction.Book_transaction_Manger;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        Book_Manager book_manager = new Book_Manager();
        Student_Manager student_manager = new Student_Manager();
        Book_transaction_Manger book_transaction_manger = new Book_transaction_Manger();
        do {
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if Want to Exit");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter your RollNumber");
                int Roll_NUmber = sc.nextInt();
                try {
                    student stu = student_manager.get(Roll_NUmber);
                    if (stu == null) {
                        throw new Student_Not_Found_Exception();
                    }
                    int stud_choice;
                    do {
                        System.out.println("Enter your choice");
                        System.out.println("Enter 1 to View All Book\nEnter 2 To Search Book by ISBN\nEnter 3 to List BY Subject\nEnter 4 to Issue Book\nEnter 5 to Return a Book\nEnter 99 Exit ");
                        stud_choice = sc.nextInt();
                        switch (stud_choice) {
                            case 1:
                                System.out.println("-------All the Book Record are------ ");
                                book_manager.ViewAllBooks();
                                break;
                            case 2:
                                System.out.println("-------Please Enter The ISBN To Book Search--------");
                                int Search_Isbn = sc.nextInt();
                                Book book = book_manager.searchBooKByIsbn(Search_Isbn);
                                if (book == null) {
                                    System.out.println("No Book With This ISBN Exists in Record");
                                } else {
                                    System.out.println(book);
                                }
                                break;
                            case 3:
                                System.out.println("-------Enter the Subject to Search------- ");
                                sc.nextLine();
                                String Search_subject = sc.nextLine();
                                book_manager.List_Books_By_Subject(Search_subject);
                                break;
                            case 4:
                                 System.out.println("-------Enter the ISBN To Issue a Book-------");
                                int Issue_isbn = sc.nextInt();
                                Book book1 = book_manager.searchBooKByIsbn(Issue_isbn);
                                try {
                                    if (book1 == null) {
                                        throw new Book_Not_Found_Exception();
                                    }
                                    if (book1.getAvailable_quantity() >= 3) {
                                        if (book_transaction_manger.issue_Book(Roll_NUmber, Issue_isbn)) {
                                            book1.setAvailable_quantity(book1.getAvailable_quantity() - 1);
                                            System.out.println("Book has Been Issued");
                                        }
                                    } else {
                                        System.out.println("The Book Has not Been Issued");
                                    }
                                } catch (Book_Not_Found_Exception bf) {
                                    System.out.println(bf);
                                }
                                break;
                            case 5:
                                System.out.println("-----Please Enter the isbn to Return Book-----");
                                int return_Isbn = sc.nextInt();
                                book = book_manager.searchBooKByIsbn(return_Isbn);
                                if (book != null) {
                                    if (book_transaction_manger.Return_Book(Roll_NUmber, return_Isbn)) {
                                        book.setAvailable_quantity(book.getAvailable_quantity() + 1);
                                        System.out.println("Thank you for Returning the book");
                                    } else {
                                        System.out.println("Could Not Return The Book ");
                                    }
                                } else {
                                    System.out.println("Book With This ISBN Does Not Exist ");
                                }
                                break;
                            case 99:
                                System.out.println("Thank You For Using Library");
                                break;
                            default:
                                System.out.println("INVALID CHOICE ");
                        }
                    } while (stud_choice != 99);
                } catch (Student_Not_Found_Exception e) {
                    System.out.println(e);
                }

            } else if (choice == 2) {//user is Library
                int Lib_Choice;
                do {
                    System.out.println("Enter 11 To View All Student\nEnter 12  to Print By Roll Number\nEnter 13 to Register a Student\nEnter 14 to Update a Student\nEnter 15 to Delete a Student ");
                    System.out.println("Enter 21 To View All Books\nEnter 22  to Print a Book  By ISBN\nEnter 23 to Add a New Book\nEnter 24 to Update a Book\nEnter 25 to Delete a Book\nEnter 26 view issue student transaction ");
                    System.out.println("Enter 31 To View All Book_Transaction ");
                    System.out.println("Enter 99 to Exit");
                    Lib_Choice = sc.nextInt();
                    switch (Lib_Choice) {
                        case 11://view all Student
                            System.out.println("-----  ALL THE STUDENT RECORDS -----");
                            student_manager.viewAllStudent();
                            break;
                        case 12://Search a student based on roll number
                            System.out.println("Enter Roll Number To Fetch Student`s Records ");
                            int get_ro = sc.nextInt();
                            student student = student_manager.get(get_ro);
                            if (student == null) {
                                System.out.println("No Records Matches This Roll Number");
                            } else {
                                System.out.println(student);
                            }
                            break;
                        case 13: //adding Student
                            System.out.println("Enter Students Details to Add");
                            String name;
                            String email_id;
                            String phone_number;
                            String address;
                            String dob;
                            int rollNo;
                            int std;
                            String division;
                            sc.nextLine();
                            System.out.println("Name");
                            name = sc.nextLine();
                            System.out.println("EmailId");
                            email_id = sc.nextLine();
                            System.out.println("Phone Number");
                            phone_number = sc.nextLine();
                            System.out.println("Address ");
                            address = sc.nextLine();
                            System.out.println("Date of Birth");
                            dob = sc.nextLine();
                            System.out.println("Roll Number");
                            rollNo = sc.nextInt();
                            System.out.println("Standard as Integer");
                            ;
                            std = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Division");
                            division = sc.nextLine();

                            student student1 = new student(name, email_id, phone_number, address, dob, rollNo, std, division);
                            System.out.println("Student is added");
                            student_manager.addAllStudent(student1);
                            break;
                        case 14://update a student
                            System.out.println("Enter the RollNumber To Modify The Records ");
                            int modify_Roll_NUmber;
                            modify_Roll_NUmber = sc.nextInt();
                            student = student_manager.get(modify_Roll_NUmber);
                            try {
                                if (student == null) {
                                    throw new Student_Not_Found_Exception();
                                }
                                sc.nextLine();
                                System.out.println("Name");
                                name = sc.nextLine();
                                System.out.println("EmailId");
                                email_id = sc.nextLine();
                                System.out.println("Phone Number");
                                phone_number = sc.nextLine();
                                System.out.println("Address ");
                                address = sc.nextLine();
                                System.out.println("Date of Birth");
                                dob = sc.nextLine();
                                System.out.println("Standard as Integer");
                                std = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Division");
                                division = sc.nextLine();
                                student_manager.Update_Student(modify_Roll_NUmber, name, email_id, phone_number, address, dob, std, division);
                                System.out.println("Student Record is update");
                            } catch (Student_Not_Found_Exception sr) {
                                System.out.println(sr);
                            }
                            break;
                        case 15: // to delete a student
                            System.out.println("Enter the RollNumber To Modify The Records ");
                            int Delete_Roll_NUmber;
                            Delete_Roll_NUmber = sc.nextInt();
                            if (student_manager.delete_student(Delete_Roll_NUmber)) {
                                System.out.println("Student record is Removed");
                            } else {
                                System.out.println("no Record With Given Roll Number Exisits");
                            }
                            break;
                        case 21://view all books
                            book_manager.ViewAllBooks();
                            break;
                        case 22://search a book by isbn
                            int search_ISBN;
                            System.out.println("Enter ISBN of The  Book to Search");
                            search_ISBN = sc.nextInt();
                            Book book = book_manager.searchBooKByIsbn(search_ISBN);
                            if (book == null) {
                                System.out.println("No Book Theis ISBN Exists in our library ");
                            } else {
                                System.out.println(book);
                            }
                            break;
                        case 23://add book
                            System.out.println("Please Enter Book Details to Add ");
                            int isbn;
                            String title;
                            String author;
                            String publisher;
                            int edition;
                            String subject;
                            int available_quantity;

                            System.out.println("ISBN");
                            isbn = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Title");
                            title = sc.nextLine();
                            System.out.println("Author");
                            author = sc.nextLine();
                            System.out.println("Publisher");
                            publisher = sc.nextLine();
                            System.out.println("Edition");
                            edition = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Subject");
                            subject = sc.nextLine();
                            System.out.println("Quantity");
                            available_quantity = sc.nextInt();
                            book = new Book(isbn, title, author, publisher, edition, subject, available_quantity);
                            book_manager.addAbook(book);
                            System.out.println("A Book Record Is Added ");
                            break;
                        case 24://update a record of a book
                            System.out.println("Please Enter the ISBN to Update the record");
                            int update_isbn;
                            update_isbn = sc.nextInt();
                            try {
                                book = book_manager.searchBooKByIsbn(update_isbn);
                                if (book == null) throw new Book_Not_Found_Exception();
                                System.out.println("Enter Book Details To Modify");
                                sc.nextLine();
                                System.out.println("Title");
                                title = sc.nextLine();
                                System.out.println("Author");
                                author = sc.nextLine();
                                System.out.println("Publisher");
                                publisher = sc.nextLine();
                                System.out.println("Edition");
                                edition = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Subject");
                                subject = sc.nextLine();
                                System.out.println("Quantity");
                                available_quantity = sc.nextInt();
                                book_manager.Update_Book(update_isbn, title, author, publisher, edition, subject, available_quantity);
                                System.out.println("Book update ");
                            } catch (Book_Not_Found_Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 25://update a record of a book
                            System.out.println("Please Enter the ISBN to Update the record");
                            int delete_isbn;
                            delete_isbn = sc.nextInt();
                            try {
                                book = book_manager.searchBooKByIsbn(delete_isbn);
                                if (book == null) throw new Book_Not_Found_Exception();
                                else if (book.getIsbn() == delete_isbn) {
                                    book_manager.deleteBook(delete_isbn);
                                    System.out.println("delete book successfully");
                                }
                            } catch (Book_Not_Found_Exception bnfe) {
                                System.out.println(bnfe);
                            }
                            break;
                        case 26:
                            System.out.println("Enter your Roll Number");
                            rollNo= sc.nextInt();
                            sc.nextLine();
                            book_transaction_manger.Total_Book_Are_Issued_Student(rollNo);
                            break;
                        case 31://to view all transaction
                            System.out.println("All The transaction are");
                            book_transaction_manger.showAll();
                            break;

                        case 99:
                            System.out.println("Thank you for using library");
                            break;
                        default:
                            System.out.println("INVALID CHOICE");
                    }
                }
                while (Lib_Choice != 99);
            }
        } while (choice != 3);
        student_manager.Writ_To_File();
        book_manager.Writ_To_File();
        book_transaction_manger.Writ_To_File();
    }
}