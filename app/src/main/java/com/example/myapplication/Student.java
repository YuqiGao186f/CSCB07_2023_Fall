package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public List<String> registeredEvents;
    public List<String> evaluatedEvents;

    public Student() {

        this.registeredEvents = new ArrayList<>();
        this.evaluatedEvents = new ArrayList<>();
    }
    public Student(String email, String name) {
        super(email, name);
        this.registeredEvents = new ArrayList<>();
        this.evaluatedEvents = new ArrayList<>();
    }

    public Student(String email, String name, List<String> registeredEvents, List<String> evaluatedEvents){
        this.email = email;
        this.name = name;
        this.registeredEvents = registeredEvents;
        this.evaluatedEvents = evaluatedEvents;
    }

}
