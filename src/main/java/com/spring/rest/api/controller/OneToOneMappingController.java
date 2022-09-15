
package com.spring.rest.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.api.dao.EmployeeDAO;
import com.spring.rest.api.model.EmpDeptMapping;
import com.spring.rest.api.repository.EmpDeptMappingRepository;
import com.spring.rest.api.service.EmpDeptMappingService;

@RestController
public class OneToOneMappingController {

	@Autowired
	private EmpDeptMappingService empMappingService;
	
	@Autowired
	private EmpDeptMappingRepository deptMappingRepository;

	@GetMapping("/employees/mapping")
	public ResponseEntity<List<EmpDeptMapping>> gelAllEmployees(@RequestParam final int pageNo,
			@RequestParam final int pageSize) {
		List<EmpDeptMapping> employee = empMappingService.getEmployees(pageNo, pageSize);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/employees/mapping/filterByDept/{deptName}")
	public ResponseEntity<List<EmpDeptMapping>> getEmployee(@PathVariable("deptName") final String deptName) {
		//return new ResponseEntity<>(empMappingService.getEmployee(deptName), HttpStatus.OK); getEmployeeByDepartmentDeptName
		return new ResponseEntity<>(deptMappingRepository.getEmployeeByDepartmentDeptName(deptName), HttpStatus.OK);
	}

	@DeleteMapping("/emp/dept-mapping")
	public void deleteEmployee(@RequestParam("id") final Long id) {
		empMappingService.deleteEmployee(id);
	}

	@PostMapping("/emp/dept-mapping")
	public ResponseEntity<EmpDeptMapping> saveEmployee(@RequestBody EmployeeDAO employeeDAO) {
		return new ResponseEntity<EmpDeptMapping>(empMappingService.saveEmployee(employeeDAO), HttpStatus.CREATED);

	}

	@PutMapping("/emp/dept-mapping/{id}")
	public EmpDeptMapping updateEmployee(@PathVariable final Long id, @RequestBody EmpDeptMapping employee) {
		// employee.setId(id);
		return empMappingService.updateEmployee(employee);
	}
}
