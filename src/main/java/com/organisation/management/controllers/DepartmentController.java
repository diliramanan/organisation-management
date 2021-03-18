package com.organisation.management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
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

import com.organisation.management.entity.Department;
import com.organisation.management.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/fetchAll")
	ResponseEntity<List<Department>> fetchAllDetails(){
		return new ResponseEntity<>(deptService.fetchAllDeptDetails(), HttpStatus.OK);
	}
	
	@GetMapping("/{deptId}")
	ResponseEntity<Optional<Department>> departmentDetails(@PathVariable int deptId){
		return new ResponseEntity<>(deptService.fetchDetails(deptId), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	ResponseEntity<String> insertDeptloyee(@RequestBody Department deptDetail){
		System.out.println(deptDetail.toString());
		deptService.insertDeptDetails(deptDetail);
		return new ResponseEntity<>("Inserted Successfully", HttpStatus.OK);
	 }
	
	@DeleteMapping("/delete/{deptId}")
	ResponseEntity<String> removeDeptloyee(@PathVariable int deptId) {
		deptService.removeDeptDetails(deptId);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/update/{deptId}")
	ResponseEntity<String> updateDetails(@PathVariable int deptId,@RequestBody Department deptDetail) {
		deptService.updateDeptDetails(deptId,deptDetail);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

}
