package com.sit.student.repository;

import com.sit.student.model.Discipline;
import com.sit.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
    List<Discipline> getDisciplineByStudentId(int id);
}
