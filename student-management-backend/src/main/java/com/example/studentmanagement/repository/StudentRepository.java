package com.example.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByStudentNameContainingIgnoreCase(String studentName);
	boolean existsByEmail(String email);
}
