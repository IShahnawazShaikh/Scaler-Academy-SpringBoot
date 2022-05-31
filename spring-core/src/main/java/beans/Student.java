package beans;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private int rollNumber;

    public Student(String firstName,int rollNumber) {
        this.firstName=firstName;
        this.rollNumber=rollNumber;
    }
}
