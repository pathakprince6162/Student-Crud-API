package com.example.application.Entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class student {

    @Id 
    private int Roll;

    private String Name;
    private int Age ;
    private String email;
    private String Subject;
    
    public int getRoll() {
        return Roll;
    }
    public void setRoll(int roll) {
        Roll = roll;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        Subject = subject;
    }
    
}
