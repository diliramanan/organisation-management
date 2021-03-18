package com.organisation.management.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column
	private int empId;
	@Column
	private String empName;
	@Column
	private String departmentName;
	@Column
	private String departmentId;

}
