package com.example.classRoomAPI.models;

import com.example.classRoomAPI.helper.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name ="attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendance")
    private Integer idAttendance;

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



    public Attendance() {
    }

    public Attendance(Integer idAttendance, LocalDate DOA, Status status) {
        this.idAttendance = idAttendance;
        this.DOA = DOA;
        this.status = status;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
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
