package beans;

import lombok.Data;

public class Student {

     private String firstName;
     private int id;
    public Student(String firstName, int id) {
        this.firstName=firstName;
        this.id=id;
    }
}
