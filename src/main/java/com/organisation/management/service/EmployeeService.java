package com.organisation.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.management.entity.Employee;
import com.organisation.management.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public Optional<Employee> fetchDetails(int empId) {
		System.out.println(empRepo.findById(empId).toString());
		return empRepo.findById(empId); 
	}

	public void insertEmpDetails(Employee empDetail) {
		empRepo.save(empDetail);
	}

	public void removeEmpDetails(int empId) {
		empRepo.deleteById(empId);
	}

	public List<Employee> fetchAllEmpDetails() {
		return empRepo.findAll();
	}

	public void updateEmpDetails(int empId,Employee empDetail) {
		Employee empDetailToUpdated = empRepo.getOne(empId);
		empDetailToUpdated.setEmpName(empDetail.getEmpName());
		empRepo.save(empDetailToUpdated);
	}

	
	
}
