package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
		
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(int EmployeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(EmployeeId);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
					
		}else {
			throw new RuntimeException("didn't find emp id");
		}
		return employee;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeId);
	}

}
