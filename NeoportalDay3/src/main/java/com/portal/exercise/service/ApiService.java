package com.portal.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.Employee;
import com.portal.exercise.repository.EmployeeRepo;

@Service
public class ApiService {


	@Autowired
	public EmployeeRepo erepo;
	

	public Employee saveDetails(Employee e)
	{
		return erepo.save(e);
	}
	public List<Employee> getDetails()
	{
		return erepo.findAll();
	}
}
