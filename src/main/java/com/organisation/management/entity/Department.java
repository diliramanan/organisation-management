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
	private int departmentKey;

	@Column
	private String departmentName;

	@Column
	private String departmentHead;

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentKey;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentKey = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public String toString() {
		return "Department [departmentKey=" + departmentKey + ", departmentName=" + departmentName + ", departmentHead="
				+ departmentHead + "]";
	}

}
