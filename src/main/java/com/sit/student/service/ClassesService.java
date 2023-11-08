package com.sit.student.service;

import com.sit.student.model.Classes;
import com.sit.student.repository.ClassesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassesService {
    private ClassesRepository classesRepository;

    public List<Classes> getListClassByDisciplineId(int id) {
        return classesRepository.getClassesByDisciplineId(id);
    }

    public void saveClass(Classes classes) {
        classesRepository.save(classes);
    }

}
