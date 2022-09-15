package com.spring.rest.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spring.rest.api.dao.EmployeeDAO;
import com.spring.rest.api.model.EmpDeptMapping;

public interface EmpDeptMappingService {

	List<EmpDeptMapping> getEmployees(int pageNo, int pageSize);

	List<EmpDeptMapping> getEmployee(String department);

	void deleteEmployee(Long id);

	EmpDeptMapping saveEmployee(@Valid EmployeeDAO employeeDAO);

	EmpDeptMapping updateEmployee(EmpDeptMapping employee);

}
