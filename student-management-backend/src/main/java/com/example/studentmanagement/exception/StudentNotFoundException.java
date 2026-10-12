package com.example.studentmanagement.exception;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(Integer id) {
		super("student not found with id: " + id);
	}
	
	public StudentNotFoundException(String studentName) {
		super("Student not found with username: " + studentName);
	}

}
