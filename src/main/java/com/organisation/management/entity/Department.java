package com.organisation.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int departmentId;
	@Column
	private String departmentName;
	@Column
	private String empName;
	@Column
	private String departmentHead;

	public Department() {
		super();
	}

	public Department(int departmentId, String departmentName, String empName, String departmentHead) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.empName = empName;
		this.departmentHead = departmentHead;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", empName="
				+ empName + ", departmentHead=" + departmentHead + "]";
	}

}
