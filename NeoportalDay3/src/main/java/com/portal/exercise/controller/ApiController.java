package com.portal.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.Employee;
import com.portal.exercise.service.ApiService;


@RestController
public class ApiController {

	@Autowired
	ApiService euser;
	
	@PostMapping("/saveEmp")
	public Employee saveEmployeeDetails(@RequestBody Employee eb) {
		return euser.saveDetails(eb);
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getEmployeeDetails()
	{
		return euser.getDetails();
	}

}
