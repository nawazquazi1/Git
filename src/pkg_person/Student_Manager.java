package pkg_person;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Student_Manager {

    ObjectOutputStream oos_student = null;
    ObjectInputStream ois_student = null;
    File student_file = null;

    ArrayList<student> student_List = null;

    @SuppressWarnings("unchekd")
    public Student_Manager() {
        student_file = new File("Student.dat");
        student_List = new ArrayList<student>();
        if (student_file.exists()) {
            try {
                ois_student = new ObjectInputStream(new FileInputStream(student_file));
                student_List = (ArrayList<student>) ois_student.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void addAllStudent(student student) {
        student_List.add(student);
    }

    public student get(int Roll_Number) {
        for (student student : student_List) {
            if (student.getRollNo() == Roll_Number) {
                return student;
            }
        }
        return null;
    }

    public void viewAllStudent() {
        for (student student : student_List) {
            System.out.println(student);
        }
    }

    public boolean delete_student(int delete_Roll_Number) {
        ListIterator<student> studentListIterator = (ListIterator<student>) student_List.listIterator();
        while (studentListIterator.hasNext()) {
            student student = studentListIterator.next();
            if (student.getRollNo() == delete_Roll_Number) {
                student_List.remove(student);
                return true;
            }
        }
        return false;
    }

    public boolean Update_Student(int update_roll_number, String name, String email_id, String phone_number, String address, String dob, int std, String divison) {
        ListIterator<student> studentListIterator = (ListIterator<student>) student_List.listIterator();
        while (studentListIterator.hasNext()) {
            student student = studentListIterator.next();
            if (student.getRollNo() == update_roll_number) {
                student.setDivison(divison);
                student.setStd(std);
                student.setName(name);
                student.setDob(dob);
                student.setEmail_id(email_id);
                student.setPhone_Number(phone_number);
                student.setAddress(address);
                return true;
            }
        }
        return false;
    }
    public void Writ_To_File(){
        try {
            oos_student=new ObjectOutputStream(new FileOutputStream(student_file));
            oos_student.writeObject(student_List);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

