package com.example.studentmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.service.StudentService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/students/api/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
     
	// http://localhost:8080/students/api/about
	@GetMapping("/about")
	public String welcomeMessage() {
		return "Student Management System Backend Application";
	}
	
	// http://localhost:8080/students/api/createStudent
	@PostMapping("/createStudent")
	public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO savedStudent = studentService.createStudent(studentDTO);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "Student data successfully saved into database");
		response.put("data", savedStudent);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	// http://localhost:8080/students/api/findStudentById/{id}
	@GetMapping("/findStudentById/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable Integer id) {
		StudentDTO dto = studentService.findStudentById(id);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "Student data successfully retrieved");
		response.put("data", dto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// http://localhost:8080/students/api/findAllStudents
	@GetMapping("/findAllStudents")
    public ResponseEntity<?> findAllStudents(){
    	List<StudentDTO> students = studentService.findAllStudents();
    	Map<String, Object> response = new HashMap<>();
    	response.put("status", "Students data successfully retrieved");
    	response.put("count", students.size());
    	response.put("data", students);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	// http://localhost:8080/students/api/updateStudent/{id}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Integer id){
		StudentDTO updatedStudent = studentService.UpdateStudent(id, studentDTO);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "Student data successfully updated");
		response.put("data", updatedStudent);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// http://localhost:8080/students/api/deleteStudent/{id}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "Student data successfully deleted");
		response.put("id", id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// http://localhost:8080/students/api/searchStudent?studentName=nagu
	@GetMapping("/searchStudent")
	public ResponseEntity<?> findStudentByName(@RequestParam String studentName) {
		List<StudentDTO> students = studentService.findStudentByName(studentName);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "Search completed successfully");
		response.put("count", students.size());
		response.put("data", students);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
