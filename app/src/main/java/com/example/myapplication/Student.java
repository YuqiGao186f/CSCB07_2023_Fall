package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public List<String> registeredEvents;

    public Student() {
        this.registeredEvents = new ArrayList<>();
    }
    public Student(String email, String name) {
        super(email, name);
        this.registeredEvents = new ArrayList<>();
    }

    public Student(String email, String name, List<String> registeredEvents){
        this.email = email;
        this.name = name;
        this.registeredEvents = registeredEvents;
    }

}
