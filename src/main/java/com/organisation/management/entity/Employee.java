package com.organisation.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int empId;
	@Column
	private String empName;
	@Column
	private String departmentName;
	@Column
	private String departmentId;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String departmentName, String departmentId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.departmentName = departmentName;
		this.departmentId = departmentId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", departmentName=" + departmentName
				+ ", departmentId=" + departmentId + "]";
	}

}
