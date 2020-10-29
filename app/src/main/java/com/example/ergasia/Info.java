package com.example.ergasia;

import java.io.Serializable;

public class Info implements Serializable {
    private int id;
    private String fname;
    private String lname;
    private int age;

    public Info(){

    }

    public Info(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public Info(int id, String fname, String lname, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }
}
