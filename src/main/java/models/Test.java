package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Test implements Serializable {

@Id@GeneratedValue
    private int id;
    private String name;
    
    @OneToMany
    @JsonManagedReference
    @JsonIgnore
    private ArrayList<Question> questions;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    Course course;
    public Test() {}

    public Test(int id, String name, ArrayList<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
 
