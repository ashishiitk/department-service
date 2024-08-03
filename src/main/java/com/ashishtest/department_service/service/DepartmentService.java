package com.ashishtest.department_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashishtest.department_service.entity.Department;
import com.ashishtest.department_service.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
	
	public Optional<Department> findById(Long id) {
		return departmentRepository.findById(id);
	}
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}
	
	
	

}
