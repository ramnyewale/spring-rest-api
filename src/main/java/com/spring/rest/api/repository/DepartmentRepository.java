package com.spring.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.api.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
