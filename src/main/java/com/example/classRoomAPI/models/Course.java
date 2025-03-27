package com.example.classRoomAPI.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private  Integer idCourse;

    @Column(name = "name",length = 100,unique = false,nullable = false)//AQUI ESTAMOS ESPECIFICANDO NOT NULL ES VERDADERO
    private  String name;

    // CREANDO RALACION (MUCHOS A UNO)
    @ManyToOne
    @JoinColumn(name = "fk_professor",referencedColumnName ="idProfessor")
    @JsonBackReference
    private Professor professor;


    public Course() {
    }

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

