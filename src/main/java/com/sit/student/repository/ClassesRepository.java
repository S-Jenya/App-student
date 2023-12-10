package com.sit.student.repository;

import com.sit.student.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    List<Classes> getClassesByDisciplineId(int id);
}
