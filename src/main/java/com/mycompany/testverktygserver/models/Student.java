package com.mycompany.testverktygserver.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student extends User implements Serializable{
    @OneToMany(mappedBy="student", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<CompletedTest> completedTests;

    public Student() {
        super();
    }

    public List<CompletedTest> getCompletedTests() {
        return completedTests;
    }

    public void setCompletedTests(List<CompletedTest> completedTests) {
        this.completedTests = completedTests;
    }
}

