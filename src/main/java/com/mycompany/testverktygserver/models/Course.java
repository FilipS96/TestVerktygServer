package com.mycompany.testverktygserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable {

@Id@GeneratedValue
    private int id;
    private String name;
    
    @OneToMany(mappedBy="course", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Test> tests;

    public Course() {}

    public Course(int id, String name, ArrayList<Test> tests) {
        this.id = id;
        this.name = name;
        this.tests = tests;
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

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}


