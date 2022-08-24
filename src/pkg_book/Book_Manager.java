package pkg_book;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Book_Manager {
    ObjectOutputStream oos_book = null;
    ObjectInputStream ois_book = null;
    File Book_file = new File("Book.dat");
    ArrayList<Book> books_lost = null;
    @SuppressWarnings("unchecked")
    public Book_Manager()  {
        books_lost = new ArrayList<Book>();
        try {
            if (Book_file.exists()) {
                ois_book = new ObjectInputStream(new FileInputStream(Book_file));
                books_lost = (ArrayList<Book>) ois_book.readObject();
            }
        }catch (IOException | ClassNotFoundException io){
            io.printStackTrace();
        }
    }

    public void addAbook(Book book) {
        books_lost.add(book);
    }

    public void ViewAllBooks() {
        for (Book book : books_lost) {
            System.out.println(book);
        }
    }

    public Book searchBooKByIsbn(int search_isbn) {
        for (Book book : books_lost) {
            if (book.getIsbn() == search_isbn) {
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int delete_isbn) {
        ListIterator<Book> bookListIterator = (ListIterator<Book>) books_lost.listIterator();
        while (bookListIterator.hasNext()) {
            Book book = bookListIterator.next();
            if (book.getIsbn() == delete_isbn) {
                books_lost.remove(book);
                return true;
            }
        }
        return false;
    }
    public boolean Update_Book(int Update_isbn,String title,String author,String publisher,int edition,String subject,int available_quantity ) {
        ListIterator<Book> bookListIterator = (ListIterator<Book>) books_lost.listIterator();
        while (bookListIterator.hasNext()) {
            Book book = bookListIterator.next();
            if (book.getIsbn() == Update_isbn) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setEdition(edition);
                book.setSubject(subject);
                book.setAvailable_quantity(available_quantity);
                return true;
            }
        }
        return false;
    }
    public void List_Books_By_Subject(String  subject){
        for (Book book:books_lost){
            if (book.getSubject().equals(subject)){
                System.out.println(book);
            }
        }
    }
    public void Writ_To_File(){
        try {
            oos_book=new ObjectOutputStream(new FileOutputStream(Book_file));
            oos_book.writeObject(books_lost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
