package com.example.classRoomAPI.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class Course {
    @Id
    // ESTO IDENTIFICA LA LLAVE PRIMARIA POR ESO PONES @ID PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)// GENERAR UN NUMERO QUE VAYA INCREMENTANDO SON ANOTACIONES MUY IMPORTANTE PARA GENERAR UN AUTOINCREMENTO  STRATEGY-IDENDITY
    //SOLAMENTE GENERO EL DE ARRIBA CON ESTRATEGY PARA PODER GENERAR UN NUMERO AUTOMATICO. TAL CUAL LO DICE LA TABLA.
    @Column(name = "id_course")// LO PONGO SIMPLE PORQ SE QUE ES UN ENTERO BASADO EN LAS TABLAS.
    private  Integer idCourse;

    @Column(name = "name",length = 100,unique = false,nullable = false)//AQUI ESTAMOS ESPECIFICANDO NOT NULL ES VERDADERO
    private  String name;

    // CREANDO RALACION (MUCHOS A UNO)
    @ManyToOne
    @JoinColumn(name = "fk_professor",referencedColumnName ="idProfessor")// con este creo el FK
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

