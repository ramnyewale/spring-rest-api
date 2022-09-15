package com.spring.rest.api.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.rest.api.dao.EmployeeDAO;
import com.spring.rest.api.model.Department;
import com.spring.rest.api.model.EmpDeptMapping;
import com.spring.rest.api.repository.DepartmentRepository;
import com.spring.rest.api.repository.EmpDeptMappingRepository;
import com.spring.rest.api.service.EmpDeptMappingService;

@Service
public class EmpDeptMappingServiceImpl implements EmpDeptMappingService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmpDeptMappingRepository deptMappingRepository;

	@Override
	public List<EmpDeptMapping> getEmployees(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		return deptMappingRepository.findAll(page).toList();
	}

	@Override
	public List<EmpDeptMapping> getEmployee(String depatment) {
		return deptMappingRepository.findByDepartmentDeptName(depatment);
	}

	@Override
	public void deleteEmployee(Long id) {

	}

	@Override
	public EmpDeptMapping updateEmployee(EmpDeptMapping employee) {
		return null;
	}

	@Override
	public EmpDeptMapping saveEmployee(EmployeeDAO employeeDAO) {
		Department department = new Department();
		department.setDeptName(employeeDAO.getDeptName());
		department = departmentRepository.save(department);

		EmpDeptMapping deptMapping = new EmpDeptMapping(employeeDAO);
		deptMapping.setDepartment(department);
		deptMapping.setEmpName(employeeDAO.getEmpName());

		return deptMappingRepository.save(deptMapping);

	}

}
