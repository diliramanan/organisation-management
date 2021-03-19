package com.organisation.management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.management.entity.Department;
import com.organisation.management.exceptions.ExceptionHandlerObj;
import com.organisation.management.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;

	public List<Department> fetchAllDept() {
		return deptRepository.findAll();
	}

	public Department fetchDept(int deptKey) {
		Optional<Department> deptDetail = deptRepository.findById(deptKey);
		if (!deptDetail.isPresent())
			throw new ExceptionHandlerObj("Invalid Department Key: " + deptKey);
		return deptDetail.get();
	}

	public void insertDeptDetails(Department deptDetail) {
		deptRepository.save(deptDetail);
	}

	public void removeDeptDetails(int deptKey) {
		if (!deptRepository.existsById(deptKey))
			throw new ExceptionHandlerObj("Invalid Department Key: " + deptKey);
		deptRepository.deleteById(deptKey);
	}

	public boolean updateDeptDetails(int deptKey, Department deptDetail) {
		if (deptRepository.existsById(deptKey)) {
			Department empDetailToUpdated = deptRepository.getOne(deptKey);
			empDetailToUpdated.setDepartmentName(deptDetail.getDepartmentName());
			empDetailToUpdated.setDepartmentHead(deptDetail.getDepartmentHead());
			deptRepository.save(empDetailToUpdated);
		} else
			throw new ExceptionHandlerObj("Invalid Department Key: " + deptKey);

		return true;
	}

}
