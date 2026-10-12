package com.example.studentmanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> StudentNotFoundExceptionHandler(StudentNotFoundException exception) {
		Map<String, Object> body = Map.of(
				"status", HttpStatus.NOT_FOUND.value(),
				"error", "NOT FOUND",
				"message", exception.getMessage()
				);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<Map<String, Object>> handleDuplicateEmail(DuplicateEmailException exception) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", HttpStatus.CONFLICT.value());
		response.put("error", "Unable to connect to the server.");
		response.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

}
