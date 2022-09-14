package com.spring.rest.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> gelAllEmployees(@RequestParam final int pageNo,
			@RequestParam final int pageSize) {
		List<Employee> employee = employeeService.getEmployees(pageNo, pageSize);
		return new ResponseEntity<>(employee, HttpStatus.OK);
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
	public ResponseEntity<Employee> updateEmployeeWithPatch(@PathVariable final Long id,
			@RequestBody Employee employee) {
		employee.setId(id);
		Employee emp = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam final String name) {
		List<Employee> resultList = employeeService.findByName(name);
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}

	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> findByNameAndLocation(@RequestParam final String name,
			@RequestParam final String location) {
		List<Employee> resultList = employeeService.findByNameAndLocation(name, location);
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}

	@GetMapping("/employees/filterByNameContaining")
	public ResponseEntity<List<Employee>> getEmployeeByNameContaining(@RequestParam final String name) {
		List<Employee> employee = employeeService.findByNameContains(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/employees/filterByNameOrLocation/jpql/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmpByNameOrLocation(@PathVariable("name") final String name,
			@PathVariable("location") final String location) {
		List<Employee> emp = employeeService.getEmpByNameOrLocation(name, location);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Integer> deleteEmpById(@PathVariable("id") final Long id) {
		Integer emp = employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
