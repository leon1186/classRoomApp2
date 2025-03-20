package com.example.classRoomAPI.models;

import java.time.LocalDate;

public class Student {
    private Integer idStudent;
    private Integer level;
    private LocalDate DOB;
    private String address;

    public Student() {
    }

    public Student(Integer idStudent, Integer level, LocalDate DOB, String address) {
        this.idStudent = idStudent;
        this.level = level;
        this.DOB = DOB;
        this.address = address;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

