package com.example.classRoomAPI.models;

import com.example.classRoomAPI.helper.Status;

import java.time.LocalDate;

public class Assistance {
    private Integer idAssistance;
    private LocalDate DOA;
    private Status status;


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
