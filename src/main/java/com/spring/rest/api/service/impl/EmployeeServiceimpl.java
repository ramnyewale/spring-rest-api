package com.spring.rest.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.spring.rest.api.model.Employee;
import com.spring.rest.api.repository.EmployeeRepository;
import com.spring.rest.api.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees(final int pageNo, final int pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		return employeeRepository.findAll(page).getContent();
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
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return employeeRepository.findByName(name, sort);
	}

	@Override
	public List<Employee> findByNameAndLocation(String name, String location) {
		return employeeRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> findByNameContains(String name) {
		return employeeRepository.findByNameContains(name);
	}

	@Override
	public List<Employee> getEmpByNameOrLocation(String name, String location) {
		return employeeRepository.getEmpByNameOrLocation(name, location);
	}

	@Override
	public Integer deleteEmployeeById(Long id) {
		return employeeRepository.deleteEmployeeById(id);
	}
}
