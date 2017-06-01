package com.mycompany.testverktygserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
    private int time;
    
    @OneToMany(mappedBy="test", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Question> questions;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    private Course course;
    
    public Test() {}

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
 
