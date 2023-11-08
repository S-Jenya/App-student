package com.sit.student.service;

import com.sit.student.model.Student;
import com.sit.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    public StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudentByName(String sname) {
        return studentRepository.findStudentByFname(sname);
    }
}
