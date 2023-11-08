package com.sit.student.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_discipline", nullable = false)
    private Discipline discipline;

    @NotBlank(message = "Поле наименование учебного занятия не может быть пустым")
    @Column(name = "name", length = 30)
    @Size(min = 1, max = 30)
    private String name;

    @Column(name = "dtstart")
    private Date dtstart;

    @Column(name = "dtend")
    private Date dtend;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "description")
    private String description;

    public Classes (Discipline discipline, String name) {
        this.discipline = discipline;
        this.name = name;
        this.dtstart = new java.util.Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", Наименование=" + name +
                ", Дата начала=" + dtstart +
                '}';
    }

}
