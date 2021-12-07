package com.example.sqlitefinaltask;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String class_name;
    private int avg;
    private String subject;

    public Student(String first_name, String last_name, String class_name, int avg) {
        this.id = 0;
        this.first_name = first_name;
        this.last_name = last_name;
        this.class_name = class_name;
        this.avg = avg;
    }

    public Student(int id, String first_name, String last_name, String class_name, int avg) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.class_name = class_name;
        this.avg = avg;
    }

    public Student(int id, String first_name, String last_name, String class_name, int avg, String subject) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.class_name = class_name;
        this.avg = avg;
        this.subject = subject;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
