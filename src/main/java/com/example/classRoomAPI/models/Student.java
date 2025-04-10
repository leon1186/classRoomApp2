package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "level")
    private Integer level;

    @Column(name = "dob")
    private LocalDate DOB;

    @Column(name = "address",length = 255,nullable = false)
    private String address;


    //CREANDO RELACION DE DOCENTE A CURSO (UNO A MUCHOS) un docente va con many courses
    @OneToMany(mappedBy = "student")// aqui estamos llamando la varaible que asignamos en el Curse
    @JsonManagedReference
    private List<Grade>grades ;// preguntar esto al profesor

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Assistance>assists;


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

