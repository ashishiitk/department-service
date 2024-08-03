package com.ashishtest.department_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashishtest.department_service.client.EmployeeClient;
import com.ashishtest.department_service.entity.Department;
import com.ashishtest.department_service.entity.DepartmentResponse;
import com.ashishtest.department_service.entity.Employee;
import com.ashishtest.department_service.service.DepartmentService;

@RestController
@RequestMapping("/department")
@RefreshScope
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired 
	private EmployeeClient employeeClient;
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department department) {
		
		return departmentService.save(department);
	}
	
	@GetMapping("/all")
	public List<Department> getAllDepartment(){
		return departmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public DepartmentResponse getDepartmentById(@PathVariable Long id) {
		Optional<Department> department = departmentService.findById(id);
		//via RestClient
		//List<Employee> restClientEmployeeList = employeeClient.getEmployeeById(id);
		//via WebClient
		List<Employee> webClientEmployeeList = employeeClient.getEmployeeFromWebClient(id);
		DepartmentResponse response = new DepartmentResponse();
		response.setDepartment(department);
		//response.setEmployee(restClientEmployeeList);
		response.setEmployee(webClientEmployeeList);
		return response;
	}
}
