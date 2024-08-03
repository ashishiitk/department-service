package com.ashishtest.department_service.client;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import com.ashishtest.department_service.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;



@Service
public class EmployeeClient {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
		
	public List<Employee> getEmployeeById(Long id){
		return  restClient
				.get()
				.uri("/dept/{id}",id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<List<Employee>>(){});
	}
	
	
	
	public List<Employee> getEmployeeFromWebClient(Long id){
		/*
		 * Mono<Object[]> response = webClientBuilder.build() 
		 *                           .get()
		 *                           .uri("http://localhost:9082/employee/dept/"+"{id}",id) .retrieve()
		 *                           .bodyToMono(Object[].class); 
		 * 
		 * Object[] objects = response.block();
		 * ObjectMapper mapper = new ObjectMapper(); 
		 * 
		 * return Arrays.stream(objects)
		 *              .map(object -> mapper.convertValue(object, Employee.class))
		 *              .collect(Collectors.toList());
		 */
		
		Mono<List<Employee>> response = webClientBuilder.build() 
										.get()
										.uri("http://EMPLOYEE-SERVICE/employee/dept/"+"{id}",id) .retrieve()
										.bodyToMono(new ParameterizedTypeReference<List<Employee>>(){}); 
		List<Employee> empList = response.block();
		return empList.stream().collect(Collectors.toList());
	}

}
