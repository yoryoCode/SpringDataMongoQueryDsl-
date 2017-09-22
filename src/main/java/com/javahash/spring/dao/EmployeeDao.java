package com.javahash.spring.dao;

import java.util.List;

import com.javahash.spring.model.Employee;
import com.javahash.spring.util.SearchCriteria;

public interface EmployeeDao {
	
	public Iterable<Employee> findAll(List<SearchCriteria> criteria);
	
	public Iterable<Employee> findAll();
	
	public Employee findOne(Long id);
	
	public Employee create(Employee employee);

}
