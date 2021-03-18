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

	public List<Department> fetchAllDept() {
		return deptRepository.findAll();
	}

	public Department fetchDept(int deptKey) {
		Optional<Department> deptDetail = deptRepository.findById(deptKey);
		return deptDetail.isPresent() ? deptDetail.get() : new Department();

	}

	public void insertDeptDetails(Department deptDetail) {
		deptRepository.save(deptDetail);
	}

	public void removeDeptDetails(int deptKey) {
		deptRepository.deleteById(deptKey);
	}

	public void updateDeptDetails(int deptKey, Department deptDetail) {
		Department empDetailToUpdated = deptRepository.getOne(deptKey);
		empDetailToUpdated.setDepartmentName(deptDetail.getDepartmentName());
		empDetailToUpdated.setDepartmentHead(deptDetail.getDepartmentHead());
		deptRepository.save(empDetailToUpdated);
	}

}
