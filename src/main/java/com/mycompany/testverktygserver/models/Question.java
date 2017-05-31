package com.mycompany.testverktygserver.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private List<Answer> answers;
   
    @ManyToOne
    @JsonBackReference
    Test test;
    
    public Question() {}

    public Question(int id, String questionText, List<Answer> answer) {
        this.id = id;
        this.question = questionText;
        this.answers = answer;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}


