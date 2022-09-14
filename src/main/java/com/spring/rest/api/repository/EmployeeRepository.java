package com.spring.rest.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.api.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	public List<Employee> findByName(final String name, final Sort sort);

	public List<Employee> findByNameAndLocation(final String name, final String location);

	public List<Employee> findByNameContains(final String name);

	// JPQL Query example
	@Query("FROM Employee WHERE name = :name OR location = :location")
	public List<Employee> getEmpByNameOrLocation(@Param("name") String name, @Param("location") String location);

	@Transactional
	@Modifying
	@Query("Delete FROM Employee WHERE id = :id")
	public Integer deleteEmployeeById(final Long id);
}
