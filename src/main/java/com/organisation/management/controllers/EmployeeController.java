package com.organisation.management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/{empId}")
	public int employeeDetails(@PathVariable int empId)
	{
		return empId;
	}

}
