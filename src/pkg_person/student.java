package pkg_person;

public class student extends Person {
    private int rollNo;
    private int std;
    private String divison;

    public student() {
        super();
    }

    public student(String name, String email_id, String phone_number, String address, String dob, int rollNo, int std, String divison) {
        super(name, email_id, phone_number, address, dob);
        this.rollNo = rollNo;
        this.std = std;
        this.divison = divison;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDivison() {
        return divison;
    }

    public void setDivison(String divison) {
        this.divison = divison;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }
    public String toString() {
        return "Student [ " +
                "rollNo = " + rollNo+
                ", std = " + std+", divison = "+divison+", name="+name+", Email_id = "+email_id+
                ", phone_number = "+Phone_Number+", address = "+address+
                ", dob = "+dob+
                ']';
    }


}

