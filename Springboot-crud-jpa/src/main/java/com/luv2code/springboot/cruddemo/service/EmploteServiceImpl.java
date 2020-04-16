package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Service
public class EmploteServiceImpl implements EmployeeService{
		
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmploteServiceImpl(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int EmployeeId) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(EmployeeId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(employeeId);
	}

}
