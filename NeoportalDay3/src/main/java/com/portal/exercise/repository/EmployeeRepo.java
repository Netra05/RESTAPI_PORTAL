package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
