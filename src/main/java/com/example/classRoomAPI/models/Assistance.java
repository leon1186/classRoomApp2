package com.example.classRoomAPI.models;

import com.example.classRoomAPI.helper.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name ="assists")
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assistance")
    private Integer idAssistance;

    @Column(name = "doa")
    private LocalDate DOA;



    private Status status;


    @ManyToOne
    @JoinColumn(name = "fk_course",referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;


    @ManyToOne
    @JoinColumn(name="fk_student",referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;



    public Assistance() {
    }

    public Assistance(Integer idAssistance, LocalDate DOA, Status status) {
        this.idAssistance = idAssistance;
        this.DOA = DOA;
        this.status = status;
    }

    public Integer getIdAssistance() {
        return idAssistance;
    }

    public void setIdAssistance(Integer idAssistance) {
        this.idAssistance = idAssistance;
    }

    public LocalDate getDOA() {
        return DOA;
    }

    public void setDOA(LocalDate DOA) {
        this.DOA = DOA;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
