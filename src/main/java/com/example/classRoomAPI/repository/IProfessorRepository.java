package com.example.classRoomAPI.repository;

import com.example.classRoomAPI.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// toca importar los repositorios con jpa y @Repository
// tambien le agrego al lado de la clase Professor que tipo de dato lleva en la llave primaria.

public interface IProfessorRepository extends JpaRepository<Professor,Integer> {
    // SI TENGO CONSULTAS PERSONALIZADAS DEBEN INR EN ESTE ESPACIO



}
