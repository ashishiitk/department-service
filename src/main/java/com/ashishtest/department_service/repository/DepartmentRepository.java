package com.ashishtest.department_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashishtest.department_service.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
	List<Department> findAll();
	
	Optional<Department> findById(Long id);
	
	Department save(Department department);

}
