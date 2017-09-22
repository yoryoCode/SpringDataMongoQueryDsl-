package com.javahash.spring.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javahash.spring.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{


}
