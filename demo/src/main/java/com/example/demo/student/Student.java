package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity     // @Entity for hibernate 冬眠的@实体
@Table
public class Student {      // Make student class to a table in our database
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // default for postgres is sequence
            generator = "student_sequence"      // generator is the sequence we just created
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // 暂时性的 意思是@Transient下面一行不需要成为Database中的一个Column
    private Integer age;

    public Student() {
    }

    public Student (Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student (String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears(); // calculate Age
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
