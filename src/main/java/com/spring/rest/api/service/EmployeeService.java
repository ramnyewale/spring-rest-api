package com.spring.rest.api.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.api.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Optional<Employee> getEmployee(final Long id);

	public Employee saveEmployee(final Employee employee);

	public Employee updateEmployee(final Employee employee);
	
	public void deleteEmployee(final Long id);

}
