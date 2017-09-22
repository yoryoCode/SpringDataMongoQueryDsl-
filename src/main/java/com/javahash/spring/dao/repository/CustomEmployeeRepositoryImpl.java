package com.javahash.spring.dao.repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.javahash.spring.model.Employee;
import com.javahash.spring.model.QEmployee;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;

public class CustomEmployeeRepositoryImpl extends QuerydslRepositorySupport implements EmployeeRepository, QuerydslBinderCustomizer<QEmployee> {
    
		
	public CustomEmployeeRepositoryImpl(MongoOperations operations) {
		super(operations);
		
	}

	@Override
    public void customize(final QuerydslBindings bindings, final QEmployee root) {
		bindings.bind(root.name).first(new SingleValueBinding<StringPath, String>() {
	        @Override
	        public Predicate bind(StringPath path, String value) {
	            return path.like(value);
	        }
	    });
    }

	@Override
	public <S extends Employee> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Employee> findAll() {
		
		return null;
	}

	@Override
	public Iterable<Employee> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	

}