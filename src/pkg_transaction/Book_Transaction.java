package pkg_transaction;

public class Book_Transaction {
    private int isbn;
    private int Roll_Number;
    private String issueDate;
    private String returnDate;

    public Book_Transaction(int isbn, int Roll_number, String issueDate, String returnDate) {
        super();
        this.isbn = isbn;
        this.Roll_Number = Roll_number;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Book_Transaction() {
    }

    public String getReturnDate() {

        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getRoll_Number() {
        return Roll_Number;
    }

    public void setRoll_Number(int roll_Number) {
        Roll_Number = roll_Number;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book_Transaction{" +
                "isbn=" + isbn +
                ", Roll_Number=" + Roll_Number +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }

}

