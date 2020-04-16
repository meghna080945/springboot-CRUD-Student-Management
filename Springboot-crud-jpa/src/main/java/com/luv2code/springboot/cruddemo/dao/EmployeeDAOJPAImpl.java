package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		
		// create a query
		TypedQuery<Employee> theQuery =
				entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}


	@Override
	public Employee findEmployeeById(int EmployeeId) {
		// TODO Auto-generated method stub
		Employee employee = entityManager.find(Employee.class, EmployeeId);
		
		return employee;
	}


	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee dbemp = entityManager.merge(employee);
		employee.setId(dbemp.getId());
	}


	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createQuery("delete from Employee where id=:theId");
		theQuery.setParameter("theId", employeeId);
		theQuery.executeUpdate();
	}

}







