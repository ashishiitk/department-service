package com.ashishtest.department_service.entity;

import lombok.Data;

@Data
public class Employee {	
	private Long id;
	private String name;
	private String email;
	private Long deptId;
}
