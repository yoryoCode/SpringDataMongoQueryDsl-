package com.javahash.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.javahash.spring.dao.EmployeeDao;
import com.javahash.spring.dao.impl.EmployeeDaoImpl;

@Configuration
public class DaoConfig {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Bean(name="employeesDao")
	public EmployeeDao getEmployeeDao() throws Exception {
		return new EmployeeDaoImpl(mongoTemplate);
	}
}
