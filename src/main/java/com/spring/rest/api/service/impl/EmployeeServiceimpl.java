package com.spring.rest.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.rest.api.model.Employee;
import com.spring.rest.api.repository.EmployeeRepository;
import com.spring.rest.api.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(final Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RuntimeException("Employee is not found for id: " + id);
		}
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByNameAndLocation(String name, String location) {
		return employeeRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> findByNameContains(String name) {
		return employeeRepository.findByNameContains(name);
	}
}
