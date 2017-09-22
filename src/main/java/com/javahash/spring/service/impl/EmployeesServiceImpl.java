package com.javahash.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javahash.spring.dao.EmployeeDao;
import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.util.SearchCriteria;

public class EmployeesServiceImpl implements IEmployeesService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Iterable<Employee> findAll(List<SearchCriteria> searchCriteriaList) {
		return employeeDao.findAll(searchCriteriaList);
	}
	
	public Employee create(Employee employee) {
		Employee empl = employeeDao.create(employee);
		return empl;
	}

	public void delete(String id) {
			
	}

	@Override
	public Employee findById(Long id) {
		return employeeDao.findOne(id);
	}

	@Override
	public Iterable<Employee> findAll() {
		return employeeDao.findAll();
	}

}
