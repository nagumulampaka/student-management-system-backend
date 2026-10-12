package com.example.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
	
    private Integer id;
    private String studentName;
    private String email;
    private String phoneNumber;
    private int age;
    private String gender;
    private String course;
    private String address;

}
