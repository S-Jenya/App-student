package com.sit.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Поле Фамилия не может быть пустым")
    @Column(name = "sname", length = 30)
    @Size(min = 1, max = 30)
    private String sname;

    @NotBlank(message = "Поле Имя не может быть пустым")
    @Column(name = "fname", length = 30)
    @Size(min = 1, max = 30)
    private String fname;

    @Column(name = "pname", length = 30)
    private String pname;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JsonIgnore
    private List<Discipline> disciplines;

    public Student(String sname, String fname, String pname) {
        this.sname = sname;
        this.fname = fname;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", Фамилия=" + sname +
                ", Имя=" + fname +
                ", Отчество=" + pname +
                '}';
    }


}
