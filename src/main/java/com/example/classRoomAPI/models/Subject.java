package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer idSubject;

    @Column(name = "name",length = 100,nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject")// aqui estamos llamando la varaible que asignamos en el Curse
    @JsonManagedReference
    private List<Grade> subjects ;// preguntar esto al profesor

    public Subject() {
    }

    public Subject(Integer idSubject, String name) {
        this.idSubject = idSubject;
        this.name = name;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
