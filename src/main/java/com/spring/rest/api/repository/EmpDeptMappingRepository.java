package com.spring.rest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.rest.api.model.EmpDeptMapping;

@Repository
public interface EmpDeptMappingRepository extends PagingAndSortingRepository<EmpDeptMapping, Long> {

	List<EmpDeptMapping> findByDepartmentDeptName(String deptName);

	@Query("FROM EmpDeptMapping WHERE department.deptName = :deptName")
	List<EmpDeptMapping> getEmployeeByDepartmentDeptName(@Param(value = "deptName") String deptName);

}