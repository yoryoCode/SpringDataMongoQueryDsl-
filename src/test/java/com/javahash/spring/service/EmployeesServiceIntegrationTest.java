package com.javahash.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahash.spring.config.AppConfigurationTest;
import com.javahash.spring.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfigurationTest.class)
public class EmployeesServiceIntegrationTest {

      @Autowired
      private IEmployeesService employeesService;
      
      @Test
      public void testGetEmployeeByAttribute() {
    	  Iterable<Employee> employees = employeesService.findEmployeeByAttributes("name", "Jorge Garcia Marin");
    	  assertTrue(employees !=null);
    	  for (Employee employee : employees) {
			System.out.println(employee);
		}
      }
      
      @Test
      public void testGetAllEmployeesByCriteria() {
    	  Iterable<Employee> employees = employeesService.findAll();
    	  assertTrue(employees !=null);
    	  for (Employee employee : employees) {
			System.out.println(employee);
		}
      }
      
}