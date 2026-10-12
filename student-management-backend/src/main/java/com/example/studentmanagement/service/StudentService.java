package com.example.studentmanagement.service;

import java.util.List;
import com.example.studentmanagement.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> findAllStudents();
	public StudentDTO findStudentById(Integer id);
	public StudentDTO createStudent(StudentDTO studentDto);
	public StudentDTO UpdateStudent(Integer id, StudentDTO studentDto);
	public void deleteStudent(Integer id);
	public List<StudentDTO> findStudentByName(String studentName);
}
