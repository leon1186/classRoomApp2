package com.example.classRoomAPI.models;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Grade {
    private Integer idGrade;
    private DecimalFormat grade;
    private LocalDate DOB;


    public Grade() {
    }

    public Grade(Integer idGrade, DecimalFormat grade, LocalDate DOB) {
        this.idGrade = idGrade;
        this.grade = grade;
        this.DOB = DOB;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public DecimalFormat getGrade() {
        return grade;
    }

    public void setGrade(DecimalFormat grade) {
        this.grade = grade;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}




