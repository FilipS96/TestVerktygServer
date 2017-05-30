package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student extends User implements Serializable{
    @Id@GeneratedValue
    private int Id;
    
    @OneToMany(mappedBy="student", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private ArrayList<CompletedTest> completedTests;

    public Student() {}
    

    public Student(ArrayList<CompletedTest> completedTests, int userId, 
            String userName, String password, String firstName, String lastName, int Id) {
        super(userId, userName, password, firstName, lastName);
        this.completedTests = completedTests;
        this.Id=Id;
    }

    public ArrayList<CompletedTest> getCompletedTests() {
        return completedTests;
    }

    public void setCompletedTests(ArrayList<CompletedTest> completedTests) {
        this.completedTests = completedTests;
    }
}

