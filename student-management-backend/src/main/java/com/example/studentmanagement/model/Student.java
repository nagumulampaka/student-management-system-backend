package com.example.studentmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "students1",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studentName", nullable = false)
    private String studentName;

    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    
    private int age;
    private String gender;
    private String course;
    private String address;
}
