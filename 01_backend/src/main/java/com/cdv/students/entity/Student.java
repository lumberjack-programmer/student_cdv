package com.cdv.students.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long Id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_branch")
    private String branch;

    public Student() {
    }

    public Student(String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
    }
}

