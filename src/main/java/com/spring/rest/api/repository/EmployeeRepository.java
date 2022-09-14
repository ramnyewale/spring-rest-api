package com.spring.rest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(final String name);

	List<Employee> findByNameAndLocation(final String name, final String location);
	
	List<Employee> findByNameContains(final String name);
}
