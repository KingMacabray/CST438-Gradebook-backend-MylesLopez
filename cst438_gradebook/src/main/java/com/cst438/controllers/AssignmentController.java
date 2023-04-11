package com.cst438.controllers;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.AssignmentIdRepository;
import com.cst438.domain.AssignmentListDTO;
import com.cst438.services.RegistrationService;
import com.cst438.domain.Assignment;
import com.cst438.domain.AssignmentAllRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
public class AssignmentController {
	
	@Autowired
	AssignmentIdRepository assignmentIdRepository;
	
	@Autowired
	AssignmentAllRepository assignmentAllRepository;
	
	@Autowired
	RegistrationService registrationService;
	
	
	@PostMapping("/assignment/{assiname}/{duedate}")
	public String createNewAssignment(@PathVariable("assiname") String assignmentName, @PathVariable("duedate") Date dDate)  {
		String email = "dwisneski@csumb.edu";
		
		
		return "assignmentId = 3";
		
	}
	
	
	@DeleteMapping("/assignment/{id}")
	public void deleteAssignment(@PathVariable("id") Integer assignmentId)  {
		Assignment assignment = assignmentIdRepository.findAssignmentById(assignmentId);
		
		
		
		
		//return "assignmentId = 3";
	}
	
	@PatchMapping("/assignment/{id}")
	public void renameAssignment(@PathVariable("id") Integer assignmentId)  {
		Assignment assignment = assignmentIdRepository.findAssignmentById(assignmentId);
		
		
		
		//return assignment;
	}
	
}
