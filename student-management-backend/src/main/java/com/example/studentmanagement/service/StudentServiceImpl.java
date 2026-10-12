package com.example.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.exception.DuplicateEmailException;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.mapper.StudentMapper;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
    private StudentMapper studentMapper;

	@Override
	public List<StudentDTO> findAllStudents() {
		List<Student> allStudents = studentRepository.findAll();
		return allStudents.stream().map(studentMapper::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StudentDTO findStudentById(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
		return studentMapper.entityToDto(student);
	}

	@Override
	public StudentDTO createStudent(StudentDTO studentDto) {
		if(studentRepository.existsByEmail(studentDto.getEmail())) {
			throw new DuplicateEmailException(studentDto.getEmail());
		}
		Student student = studentMapper.dtoToEntity(studentDto);
		Student savedStudent = studentRepository.save(student);
		return studentMapper.entityToDto(savedStudent);
	}

	@Override
	public StudentDTO UpdateStudent(Integer id, StudentDTO studentDto) {
		Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
		existingStudent.setStudentName(studentDto.getStudentName());
		existingStudent.setAge(studentDto.getAge());
		existingStudent.setEmail(studentDto.getEmail());
		existingStudent.setGender(studentDto.getGender());
		existingStudent.setAddress(studentDto.getAddress());
		existingStudent.setCourse(studentDto.getCourse());
		existingStudent.setPhoneNumber(studentDto.getPhoneNumber());
		return studentMapper.entityToDto(existingStudent);
	}
	
	@Override
	public void deleteStudent(Integer id) {
		Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
	    studentRepository.delete(existingStudent);
	}

	@Override
	public List<StudentDTO> findStudentByName(String studentName) {
		List<Student> students = studentRepository.findByStudentNameContainingIgnoreCase(studentName);
		if(students.isEmpty()) {
			throw new StudentNotFoundException(studentName);
		}
		return students.stream().map(studentMapper::entityToDto).collect(Collectors.toList());
	}

}
