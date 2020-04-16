package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findEmployeeById(int EmployeeId);
	
	public void saveEmployee(Employee employee);

	void deleteById(int employeeId);
	
		
}
