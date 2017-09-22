package com.javahash.spring.dao.repository;

import com.javahash.spring.model.Employee;

public interface CustomEmployeeRepositoryInterface {
	Iterable<Employee> findAllEmployees();
}
