package com.mycompany.testverktygserver.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Teacher extends User implements Serializable{
    
    public Teacher() {
        super();
    }

}

