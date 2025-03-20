package com.example.classRoomAPI.models;


import java.time.LocalDate;

public class Registration {
    private Integer idRegistration;
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
