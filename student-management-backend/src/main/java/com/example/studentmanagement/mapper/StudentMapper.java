package com.example.studentmanagement.mapper;

import org.springframework.context.annotation.Configuration;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.model.Student;

@Configuration
public class StudentMapper {
	
	// Entity → DTO
	public StudentDTO entityToDto(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setId(student.getId());
		dto.setStudentName(student.getStudentName());
		dto.setEmail(student.getEmail());
		dto.setGender(student.getGender());
		dto.setPhoneNumber(student.getPhoneNumber());
		dto.setAge(student.getAge());
		dto.setCourse(student.getCourse());
		dto.setAddress(student.getAddress());
		return dto;
	}
	
	// DTO → Entity
	public Student dtoToEntity(StudentDTO dto){
		Student student = new Student();
		student.setStudentName(dto.getStudentName());
		student.setEmail(dto.getEmail());
		student.setGender(dto.getGender());
		student.setPhoneNumber(dto.getPhoneNumber());
		student.setAge(dto.getAge());
		student.setCourse(dto.getCourse());
		student.setAddress(dto.getAddress());
		return student;
	}

}
