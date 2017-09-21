package com.javahash.spring.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.data.mongodb.repository.support.SpringDataMongodbQuery;

import com.javahash.spring.model.Employee;
import com.javahash.spring.model.QEmployee;
import com.querydsl.core.types.Predicate;

public class EmployeeRepositoryCustomQueryDsl
extends QuerydslRepositorySupport
 {

   public EmployeeRepositoryCustomQueryDsl(MongoOperations operations) {
		super(operations);
		// TODO Auto-generated constructor stub
	}

   public Iterable<Employee> findAllPredicate() {
       QEmployee employee = QEmployee.employee;
       Predicate predicate = employee.age.eq(40);
       SpringDataMongodbQuery<Employee> query =  from(employee)
    		   .where(predicate);
       return query.fetch();
   }
}
