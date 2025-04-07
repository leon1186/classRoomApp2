package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Entity
@Table(name="Grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_grade")
    private Integer idGrade;

    @Column(name = "grade" ,nullable = false)
    private DecimalFormat grade;

    @Column(name = "doe" ,nullable = false)
    private LocalDate DOE;

    @ManyToOne
    @JoinColumn(name = "fk_student",referencedColumnName ="idStudent")// con este creo el FK
    @JsonBackReference
    private Student student;
    @ManyToOne
    @JoinColumn(name = "fk_subject",referencedColumnName ="idSubject")// con este creo el FK
    @JsonBackReference
    private Subject subject;


    public Grade() {
    }

    public Grade(Integer idGrade, DecimalFormat grade, LocalDate DOE) {
        this.idGrade = idGrade;
        this.grade = grade;
        this.DOE = DOE;
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

    public LocalDate getDOE() {
        return DOE;
    }

    public void setDOE(LocalDate DOE) {
        this.DOE = DOE;
    }
}




