package com.cst438.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.Course;
import com.cst438.domain.CourseRepository;
import com.cst438.domain.Enrollment;
import com.cst438.domain.EnrollmentDTO;
import com.cst438.domain.EnrollmentRepository;

@RestController
public class EnrollmentController {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;

	/*
	 * endpoint used by registration service to add an enrollment to an existing
	 * course.
	 */
	@PostMapping("/enrollment")
	@Transactional
	public EnrollmentDTO addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
		
		//TODO  complete this method in homework 4
		/*/Course c = courseRepository.findByCourse_id(enrollmentDTO.course_id);
		//if (c != null) {
			Enrollment e = new Enrollment();
			e.setCourse(c);
			e.setStudentEmail(enrollmentDTO.studentEmail);
			e.setStudentName(enrollmentDTO.studentName);
			e.setCourse(c);
			Enrollment es = enrollmentRepository.save(e);
			enrollmentDTO.id = es.getId();
			return enrollmentDTO;
			
		//} else {
		//	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
		//			"Course does not exist. " + enrollmentDTO.course_id);
		//}*/
		Enrollment e = new Enrollment();
		//e.setCourse(c);
		e.setStudentEmail(enrollmentDTO.studentEmail);
		e.setStudentName(enrollmentDTO.studentName);
		Course c = courseRepository.findByCourse_id(enrollmentDTO.course_id);
		//e.setCourse(c);
		if (c == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
								"Course does not exist. " + enrollmentDTO.course_id);
		}
		e.setCourse(c);
		e = enrollmentRepository.save(e);
		enrollmentDTO.id = e.getId();
		return enrollmentDTO;
		
		
		//return null;
		
	}

}
