package pkg_Exception;

import java.io.Serial;

public class Book_Not_Found_Exception extends Exception{
    @Serial
    private static final long serialVersionUID=1L;
    public Book_Not_Found_Exception(){
    }

    @Override
    public String toString() {
        return "Book_Not_Found_Exception is Generated";
    }
}

