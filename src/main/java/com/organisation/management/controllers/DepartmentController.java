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

import com.organisation.management.entity.Department;
import com.organisation.management.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	@GetMapping("/fetchAll")
	ResponseEntity<List<Department>> fetchAllDept() {
		return new ResponseEntity<>(deptService.fetchAllDept(), HttpStatus.OK);
	}

	@GetMapping("/{deptKey}")
	ResponseEntity<Department> fetchDept(@PathVariable int deptKey) {
		return new ResponseEntity<>(deptService.fetchDept(deptKey), HttpStatus.OK);
	}

	@PostMapping("/insert")
	ResponseEntity<String> insertDeptloyee(@RequestBody Department deptDetail) {
		System.out.println(deptDetail.toString());
		deptService.insertDeptDetails(deptDetail);
		return new ResponseEntity<>("Inserted Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{deptKey}")
	ResponseEntity<String> removeDeptloyee(@PathVariable int deptKey) {
		deptService.removeDeptDetails(deptKey);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/update/{deptKey}")
	ResponseEntity<String> updateDetails(@PathVariable int deptKey, @RequestBody Department deptDetail) {
		deptService.updateDeptDetails(deptKey, deptDetail);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

}
