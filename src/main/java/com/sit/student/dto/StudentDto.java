package com.sit.student.dto;

import com.sit.student.model.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String sname;
    private String fname;
    private String pname;

    public StudentDto(Student student) {
        this.fname = student.getFname();
        this.sname = student.getSname();
        this.pname = student.getPname();
    }
}
