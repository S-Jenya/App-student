package com.sit.student.service;

import com.sit.student.exception.NotFoundException;
import com.sit.student.model.Discipline;
import com.sit.student.repository.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineService {
    private DisciplineRepository disciplineRepository;
    public void save(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public List<Discipline> getListDisciplinByStudentId(int id){
        return disciplineRepository.getDisciplineByStudentId(id);
    }

    public Discipline findById(int id){
        return disciplineRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
