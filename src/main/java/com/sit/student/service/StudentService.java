package com.sit.student.service;

import com.sit.student.exception.NotFoundException;
import com.sit.student.model.Student;
import com.sit.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {
    public StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
    public List<Student> findAllStudentByName(String sname) {
        return studentRepository.findStudentByFname(sname);
    }
}
