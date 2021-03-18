package com.organisation.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organisation.management.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
