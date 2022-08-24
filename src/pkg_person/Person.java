package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {
    protected String name;
    protected String email_id;
    protected String Phone_Number;
    protected String address;
    protected String dob;


    public Person() {
        super();
    }

    public Person(String name, String email_id, String Phone_Number, String address, String dob) {
        super();
        this.setName(name);
        this.email_id = email_id;
        this.address = address;
        this.setDob(dob);
        this.Phone_Number = Phone_Number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        boolean isvalid_dob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
        if (isvalid_dob) {
            this.dob = dob;
        } else {
            this.dob = "01-06-2005";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean isvalid_name = Pattern.matches("[a-zA-Z]+", name);
        if (isvalid_name) {
            this.name = name;
        } else {
            this.name = "Default name";
        }
    }
}

