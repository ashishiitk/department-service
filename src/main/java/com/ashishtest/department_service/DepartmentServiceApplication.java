package com.ashishtest.department_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication()
@EnableDiscoveryClient()
@LoadBalancerClient(value="EMPLOYEE-SERVICE")
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}	
	
	@Bean	
	RestClient restClient() {
	 // return RestClient.builder().baseUrl("http://load-test/employee").build();
	  return RestClient.create("http://EMPLOYEE-SERVICE/employee");
	}
	
	@Bean	
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	
	
	
}
