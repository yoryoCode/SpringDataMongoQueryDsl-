package com.javahash.spring.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahash.spring.config.AppConfigurationTest;
import com.javahash.spring.model.Employee;
import com.javahash.spring.model.Skill;
import com.javahash.spring.util.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigurationTest.class)
public class EmployeesServiceIntegrationTest {

	@Autowired
	private IEmployeesService employeesService;
	
	@Test
	public void testGetAllEmployees() {

		Iterable<Employee> employees = employeesService.findAll();
		assertTrue(employees != null);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void testGetAllEmployeesByCriteria() {

		List<SearchCriteria> searchCriteriaList = new ArrayList<SearchCriteria>();
		SearchCriteria crit1 = new SearchCriteria("age", ">", "38");
		//SearchCriteria crit2 = new SearchCriteria("age", ":", "39");
		searchCriteriaList.add(crit1);
		//searchCriteriaList.add(crit2);

		Iterable<Employee> employees = employeesService.findAll(searchCriteriaList);
		assertTrue(employees != null);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void testCreateEmployee() {

		Employee employee = new Employee();
		employee.setAge(27);
		employee.setName("Deyanira Marquez Campos");
		List<Skill> skills = new ArrayList<Skill>();
		Skill skillJava = new Skill();
		skillJava.setExperience(5);
		skillJava.setName("Administración Comercial");
//		Skill skillRest = new Skill();
//		skillRest.setExperience(3);
//		skillRest.setName("SpringData");
		skills.add(skillJava);
		//skills.add(skillRest);

		employee.setSkills(skills);

		Employee returnEmployee = employeesService.create(employee);
		assertTrue(returnEmployee != null);
		assertTrue(returnEmployee.getId() != null);
	}

}