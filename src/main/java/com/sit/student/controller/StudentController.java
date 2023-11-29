package com.sit.student.controller;

import com.sit.student.dto.StudentDto;
import com.sit.student.model.Student;
import com.sit.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    @PostMapping("api/student/v1/student")
    public ResponseEntity<String> addContact(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.ok().body("Студент успешно зарегистрирован!");
    }

    @GetMapping("api/student/v1/student")
    public List<StudentDto> getContact() {
        return studentService.findAll().stream()
                .map(StudentDto::new)
                .toList();
    }

    @GetMapping("api/student/v1/student/{id}")
    public Student getByIdContact(@PathVariable Integer id) {
        return studentService.findById(id);
    }

}
