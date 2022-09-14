package com.spring.rest.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.api.model.Employee;
import com.spring.rest.api.service.EmployeeService;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${spring.application.version}")
	private String appVersion;

	@Autowired
	private EmployeeService employeeService;	
	
	@GetMapping("/employees")
	public List<Employee> gelAllEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") final Long id) {		
		return employeeService.getEmployee(id);
	}

	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestParam("id") final Long id) {
		employeeService.deleteEmployee(id);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Save method called..!!");
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable final Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return employeeService.updateEmployee(employee);
	}
	
	@PatchMapping("/employees-patch/{id}")
	public Employee updateEmployeeWithPatch(@PathVariable final Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return employeeService.updateEmployee(employee);
	}

}
