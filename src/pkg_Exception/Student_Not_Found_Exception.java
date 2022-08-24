package pkg_Exception;

public class Student_Not_Found_Exception extends Exception {

    private  static final long serialVersionUID=1L;
    public Student_Not_Found_Exception() {
        super();
    }
    @Override
    public String toString() {

        return "Student_Not_Found_Exception is Generated";
    }
}
