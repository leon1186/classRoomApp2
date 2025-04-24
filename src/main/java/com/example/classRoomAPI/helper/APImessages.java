package com.example.classRoomAPI.helper;

public enum APImessages {
    ERROR_PROFESSOR_NOT_FOUND("The professor you looking for ,is not in db "),
    EROOR_STUDENT_NOT_FOUND(" The student is not found ")
    ;

    private String message;

    APImessages() {
    }

    APImessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
