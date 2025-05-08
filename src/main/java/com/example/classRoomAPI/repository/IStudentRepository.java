package com.example.classRoomAPI.repository;

import com.example.classRoomAPI.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
