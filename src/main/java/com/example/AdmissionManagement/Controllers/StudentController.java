package com.example.AdmissionManagement.Controllers;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.AdmissionManagement.Entites.Student;
import com.example.AdmissionManagement.Services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/student")
	public ResponseEntity<String> student(@RequestBody @Valid Student student) {
		Student studentSaved=studentService
				.student(student);
		return Optional.ofNullable(studentSaved)
				.filter(stu->stu.getStudentId()>0)
				.map(stu->{
					URI location = ServletUriComponentsBuilder
		                    .fromCurrentRequest()
		                    .path("/{studentId}")
		                    .buildAndExpand(stu.getStudentId())
		                    .toUri();
					HttpHeaders headers=new HttpHeaders();
					headers.setLocation(location);
					return new ResponseEntity<>("Student saved successfull",headers, HttpStatus.CREATED);
				})
				.orElseGet(()->{
					if(Objects.isNull(studentSaved)) {
						return new ResponseEntity<>("No seats available for given Department"
								+ "and AdmissionType",HttpStatus.BAD_REQUEST);
					}
					else {
					 return new ResponseEntity<>("Internal Server Error Occurred",
							 HttpStatus.INTERNAL_SERVER_ERROR);	
					}
				});
		
	}
	
	

}
