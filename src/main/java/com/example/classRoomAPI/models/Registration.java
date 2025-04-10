package com.example.classRoomAPI.models;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private Integer idRegistration;

    @Column(name = "dor")
    private LocalDate DOR;

    public Registration() {
    }

    public Registration(Integer idRegistration, LocalDate DOR) {
        this.idRegistration = idRegistration;
        this.DOR = DOR;
    }

    public Integer getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Integer idRegistration) {
        this.idRegistration = idRegistration;
    }

    public LocalDate getDOR() {
        return DOR;
    }

    public void setDOR(LocalDate DOR) {
        this.DOR = DOR;
    }
}
