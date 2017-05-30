package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question implements Serializable {
    
@Id@GeneratedValue
    private int id;
    private String question; 
    
    @OneToMany(mappedBy="question", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private ArrayList<Option> options;
   
    @ManyToOne
    @JsonBackReference
    Test test;
    
    public Question() {}

    public Question(int id, String questionText, ArrayList<Option> options) {
        this.id = id;
        this.question = questionText;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
}


