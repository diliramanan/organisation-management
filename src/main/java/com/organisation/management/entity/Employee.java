package com.organisation.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	
	@Id
	@Column
	private int empId;
	@Column
	private String name;
	@Column
	private String departmentName;
	@Column
	private String departmentId;

}
