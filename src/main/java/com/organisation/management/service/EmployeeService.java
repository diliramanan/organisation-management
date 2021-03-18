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
	
	public Employee fetchEmp(int empId) {
		Optional<Employee> emp = empRepo.findById(empId);
		return emp.isPresent()?emp.get():new Employee(); 
	}

	public void insertEmp(Employee empDetail) {
		empRepo.save(empDetail);
	}

	public void removeEmp(int empId) {
		empRepo.deleteById(empId);
	}

	public List<Employee> fetchAllEmpDetails() {
		return empRepo.findAll();
	}

	public void updateEmp(int empId,Employee empDetail) {
		Employee empDetailToUpdate = empRepo.getOne(empId);
		empDetailToUpdate.setEmpName(empDetail.getEmpName());
		empDetailToUpdate.setEmpAddress(empDetail.getEmpName());
		empRepo.save(empDetailToUpdate);
	}

	
	
}
