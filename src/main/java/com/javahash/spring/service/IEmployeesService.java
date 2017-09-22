package com.javahash.spring.service;

import java.util.List;

import com.javahash.spring.model.Employee;
import com.javahash.spring.util.SearchCriteria;

public interface IEmployeesService {
	
	public Employee findById(Long id);
	
	public Iterable<Employee> findAll(List<SearchCriteria> searchCriteria);
	
	public Iterable<Employee> findAll();
	
	public Employee create(Employee employee);
	
	public void delete(String id);

}
