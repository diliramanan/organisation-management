package com.organisation.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.management.entity.Department;
import com.organisation.management.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository deptRepository;

	public List<Department> fetchAllDeptDetails() {
		return deptRepository.findAll();
	}

	public Optional<Department> fetchDetails(int deptId) {
		return deptRepository.findById(deptId);
	}

	public void insertDeptDetails(Department deptDetail) {
		deptRepository.save(deptDetail);
	}

	public void removeDeptDetails(int deptId) {
		deptRepository.deleteById(deptId);
	}

	public void updateDeptDetails(int deptId, Department deptDetail) {
		Department empDetailToUpdated = deptRepository.getOne(deptId);
		empDetailToUpdated.setDepartmentName(deptDetail.getDepartmentName());
		empDetailToUpdated.setDepartmentHead(deptDetail.getDepartmentHead());
		deptRepository.save(empDetailToUpdated);
	}

}
