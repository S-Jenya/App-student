package com.sit.student.controller;

import com.sit.student.dto.ClassDto;
import com.sit.student.model.Classes;
import com.sit.student.model.Discipline;
import com.sit.student.service.ClassesService;
import com.sit.student.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClassesController {

    ClassesService classesService;
    DisciplineService disciplineService;

    @PostMapping("api/classes/v1/class")
    public ResponseEntity<String> saveClass(@RequestBody ClassDto classDto) {
        Discipline discipline = disciplineService.findById(classDto.getIdDiscipline());
        classesService.saveClass(new Classes(discipline, classDto.getClassName()));
        return ResponseEntity.ok().body("Урок успешно создан!");
    }

    @GetMapping("api/classes/v1/discipline/class/{id}")
    public List<Classes> listDiscipline(@PathVariable int id) {
        return classesService.getListClassByDisciplineId(id);
    }



}
