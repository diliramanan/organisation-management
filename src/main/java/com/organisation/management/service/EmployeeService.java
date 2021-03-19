package com.organisation.management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.management.entity.Employee;
import com.organisation.management.exceptions.ExceptionHandlerObj;
import com.organisation.management.repository.EmployeeRepository;

@Service
@Transactional 
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee fetchEmp(int empId) {
		// System.out.println(empRepo.findByEmpId(empId));
		Optional<Employee> emp = empRepo.findById(empId);
		if (!emp.isPresent())
			throw new ExceptionHandlerObj("Invalid Empoyee ID: " + empId);
		return emp.get();
	}

	public void insertEmp(Employee empDetail) {
		empRepo.save(empDetail);
	}

	public void removeEmp(int empId) {
		if (!empRepo.existsById(empId))
			throw new ExceptionHandlerObj("Invalid Empoyee ID: " + empId);
		empRepo.deleteById(empId);
	}

	public List<Employee> fetchAllEmpDetails() {
		return empRepo.findAll();
	}

	public boolean updateEmp(int empId, Employee empDetail) {
		if (empRepo.existsById(empId)) {
			Employee empDetailToUpdate = empRepo.getOne(empId);
			empDetailToUpdate.setEmpName(empDetail.getEmpName());
			empDetailToUpdate.setEmpAddress(empDetail.getEmpName());
			empRepo.save(empDetailToUpdate);
		} else
			throw new ExceptionHandlerObj("Invalid Empoyee ID: " + empId);

		return true;
	}

}
