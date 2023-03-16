package com.cst438.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

	
	@PostMapping("/assignment")
	public String createNewAssignment()  {
		return "assignmentId = 3";
	}
	
	
}
