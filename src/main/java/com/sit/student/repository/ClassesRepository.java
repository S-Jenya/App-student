package com.sit.student.repository;

import com.sit.student.model.Classes;
import com.sit.student.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    List<Classes> getClassesByDisciplineId(int id);
}
