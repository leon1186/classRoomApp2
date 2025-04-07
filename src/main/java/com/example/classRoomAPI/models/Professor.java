package com.example.classRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Professor {
    private Integer idProfessor;
    private String speciality;

    //CREANDO RELACION DE DOCENTE A CURSO (UNO A MUCHOS) un docente va con many courses
    @OneToMany(mappedBy = "professor")// aqui estamos llamando la varaible que asignamos en el Curse
    @JsonManagedReference
    private List<Course> courses;// preguntar esto al profesor

    public Professor() {
    }

    public Professor(Integer idProfessor, String speciality) {
        this.idProfessor = idProfessor;
        this.speciality = speciality;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
