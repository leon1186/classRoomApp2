package com.example.classRoomAPI.repository;

import com.example.classRoomAPI.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository  extends JpaRepository<Grade,Integer> {
}
