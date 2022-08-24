package pkg_person;

public class Librarian extends Person {
    private int id;
    private String doj;


    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", doj='" + doj + ",name=" + name + ",Email_id=" + email_id +
                ",phone_number=" + Phone_Number + ",address=" + address +
                ",dob=" + dob +
                '}';
    }

    public Librarian(String name, String email_id, String Phone_Number, String address, String dob, String doj, int id) {
        super(name, email_id, Phone_Number, address, dob);
        this.doj = doj;
        this.id = id;
    }

    public Librarian() {
        super();
    }
}

