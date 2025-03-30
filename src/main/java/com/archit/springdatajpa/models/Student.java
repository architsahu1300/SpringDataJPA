package com.archit.springdatajpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Student {
    @Id
    private int rollNumber;
    private String name;
    private long marks;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", Name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }
}
