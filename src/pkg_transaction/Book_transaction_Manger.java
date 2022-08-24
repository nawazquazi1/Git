package pkg_transaction;

import pkg_book.Book;
import pkg_person.student;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unchecked")
public class Book_transaction_Manger {

    ObjectOutputStream oos_book = null;
    ObjectInputStream ois_book = null;
    File Book_Transaction_file = null;

    ArrayList<Book_Transaction> Book_Transaction_List = null;

    @SuppressWarnings("uncheked")
    public Book_transaction_Manger() {
        Book_Transaction_file = new File("book_transaction.dat");
        Book_Transaction_List = new ArrayList<Book_Transaction>();
        if (Book_Transaction_file.exists()) {
            try {
                ois_book = new ObjectInputStream(new FileInputStream(Book_Transaction_file));
//                Book_Transaction_List = (ArrayList<Book_Transaction>) ois_book.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean issue_Book(int Roll_Number, int isbn) {
        int total_book_issue = 0;
        for (Book_Transaction book_transaction : Book_Transaction_List) {
            if ((book_transaction.getRoll_Number() == Roll_Number) && (book_transaction.getReturnDate() == null)) {
                total_book_issue += 1;
            }
            if (total_book_issue >= 3) {
                System.out.println("Not issue book already three book issue ");
                return false;
            }
        }
        String issue_Date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Book_Transaction book_transaction = new Book_Transaction(isbn, Roll_Number, issue_Date, null);
        Book_Transaction_List.add(book_transaction);
        return true;
    }

    public void Total_Book_Are_Issued_Student(int Roll_Number) {
        for (Book_Transaction book_transaction : Book_Transaction_List) {
            if (book_transaction.getRoll_Number() == Roll_Number) {
                System.out.println("Book -> " + book_transaction);
//                System.out.println("Total book issue are -> " + total_book_issue);
            } else {
                System.out.println("No transaction ");
            }
        }
    }

    public boolean Return_Book(int Roll_Number, int isbn) {
        for (Book_Transaction book_transaction : Book_Transaction_List) {
            if (book_transaction.getRoll_Number() == Roll_Number && (book_transaction.getReturnDate() != null && book_transaction.getIsbn() == isbn)) {
                String Return_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                book_transaction.setReturnDate(Return_date);
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        for (Book_Transaction book_transaction : Book_Transaction_List) {
            if (book_transaction == null) {
                System.out.println("No transaction available2");
            }
            System.out.println(book_transaction);
        }
    }

    public void Writ_To_File() {
        try {
            oos_book = new ObjectOutputStream(new FileOutputStream(Book_Transaction_file));
            oos_book.writeObject(Book_Transaction_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

