package com.organisation.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/fetchAllEmp")
	ResponseEntity<List<Employee>> fetchAllEmp(){
		return new ResponseEntity<>(empService.fetchAllEmpDetails(), HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	ResponseEntity <Employee> employeeDetail(@PathVariable int empId){
		return new ResponseEntity<>(empService.fetchEmp(empId), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	ResponseEntity<String> insertEmployee(@RequestBody Employee empDetail){
		empService.insertEmp(empDetail);
		return new ResponseEntity<>("Inserted Successfully", HttpStatus.OK);
	 }
	
	@DeleteMapping("/delete/{empId}")
	ResponseEntity<String> removeEmployee(@PathVariable int empId) {
		empService.removeEmp(empId);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	ResponseEntity<String> updateDetails(@PathVariable int empId,@RequestBody Employee empDetail) {
		empService.updateEmp(empId,empDetail);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

}
