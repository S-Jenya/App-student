package com.sit.student.controller;

import com.sit.student.dto.DisciplineDto;
import com.sit.student.model.Discipline;
import com.sit.student.model.Student;
import com.sit.student.service.DisciplineService;
import com.sit.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DisciplineController {

    DisciplineService disciplineService;
    StudentService studentService;

    @GetMapping("api/discipline/v1/discipline/{id}")
    public Discipline getDiscipline(@PathVariable int id) {
        return disciplineService.findById(id);
    }

    @GetMapping("api/discipline/v1/discipline/student/{id}")
    public List<Discipline> getDisciplineStudent(@PathVariable int id) {
        return disciplineService.getListDisciplinByStudentId(id);
    }

    @PostMapping("api/discipline/v1/discipline")
    public ResponseEntity<String> saveDiscipline(@RequestBody DisciplineDto discipline) {
        Student student = studentService.findById(discipline.getIdStudent());
        disciplineService.save(new Discipline(student, discipline.getName(), discipline.getHours()));
        return ResponseEntity.ok().body("Дисциплина успешно создана!");
    }



}
