package com.javahash.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.data.mongodb.repository.support.SpringDataMongodbQuery;

import com.javahash.spring.dao.EmployeeDao;
import com.javahash.spring.dao.repository.EmployeeRepository;
import com.javahash.spring.dao.util.EmployeePredicatesBuilder;
import com.javahash.spring.model.Employee;
import com.javahash.spring.model.QEmployee;
import com.javahash.spring.util.SearchCriteria;

public class EmployeeDaoImpl extends QuerydslRepositorySupport implements EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeDaoImpl(MongoOperations operations) {
		super(operations);
	}
	
	@Override
	public Iterable<Employee> findAll(){
		return employeeRepository.findAll();
	}

	@Override
	public Iterable<Employee> findAll(List<SearchCriteria> criteria) {
		
		QEmployee employee = QEmployee.employee;
	    
		EmployeePredicatesBuilder employeePredicates = new EmployeePredicatesBuilder();
		
		for (SearchCriteria searchCriteria : criteria) {
			employeePredicates.with(
					searchCriteria.getKey(), searchCriteria.getOperation(), searchCriteria.getValue());
		}		
	    
		SpringDataMongodbQuery<Employee> query =  from(employee)
	    		   .where(employeePredicates.build());
		
	    return query.fetch();
				
	}

	@Override
	public Employee findOne(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}
