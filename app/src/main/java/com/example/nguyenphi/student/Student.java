package com.example.nguyenphi.student;

import java.io.Serializable;

/**
 * Created by nguyenphi on 19/04/2017.
 */

public class Student implements Serializable {
    String id, name, email;

    public Student() {

    }

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
