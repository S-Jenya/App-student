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
@Table(name = "discipline")
@NoArgsConstructor
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_student", nullable = false)
    @JsonIgnore
    private Student student;

    @NotBlank(message = "Поле наименования дисциплины не может быть пустым")
    @Column(name = "name", length = 30)
    @Size(min = 1, max = 30)
    private String name;

    @Column(name = "hours")
    private Integer hours;


    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Classes> classes;

    public Discipline(Student student, String name, int hours) {
        this.student = student;
        this.name = name;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", Наименование=" + name +
                ", Часы=" + hours +
                '}';
    }

}
