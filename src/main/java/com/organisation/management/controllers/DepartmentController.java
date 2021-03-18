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

import com.organisation.management.entity.Department;
import com.organisation.management.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/fetchAll")
	List<Department> fetchAllDetails(){
		return deptService.fetchAllDeptDetails();
	}
	
	@GetMapping("/{deptId}")
	 Optional<Department> departmentDetails(@PathVariable int deptId){
		return deptService.fetchDetails(deptId);
	}
	
	@PostMapping("/insert")
	 void insertDeptloyee(@RequestBody Department deptDetail){
		System.out.println(deptDetail.toString());
		deptService.insertDeptDetails(deptDetail);
	 }
	
	@DeleteMapping("/delete/{deptId}")
	void removeDeptloyee(@PathVariable int deptId) {
		deptService.removeDeptDetails(deptId);
	}

	@PutMapping("/update/{deptId}")
	void updateDetails(@PathVariable int deptId,@RequestBody Department deptDetail) {
		deptService.updateDeptDetails(deptId,deptDetail);
	}

}
