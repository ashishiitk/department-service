package com.ashishtest.department_service.entity;

import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class DepartmentResponse {
	
	private Optional<Department> department;
	private List<Employee> employee;

}
