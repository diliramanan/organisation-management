package com.organisation.management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.management.entity.Employee;
import com.organisation.management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/fetchAll")
	List<Employee> fetchAllDetails(){
		return empService.fetchAllEmpDetails();
	}
	
	@GetMapping("/{empId}")
	 Optional<Employee> employeeDetails(@PathVariable int empId){
		return empService.fetchDetails(empId);
	}
	
	@PostMapping("/insert")
	 void insertEmployee(@RequestBody Employee empDetail){
		System.out.println(empDetail.toString());
		empService.insertEmpDetails(empDetail);
	 }
	
	@DeleteMapping("/delete/{empId}")
	void removeEmployee(@PathVariable int empId) {
		empService.removeEmpDetails(empId);
	}
	
	@PutMapping("/update/{empId}")
	void updateDetails(@PathVariable int empId,@RequestBody Employee empDetail) {
		empService.updateEmpDetails(empId,empDetail);
	}

}
