package com.spring.rest.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emp_dept_mapping")
public class EmpDeptMapping implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = -676969859561662635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String empName;

	@OneToOne
	@JoinColumn(name = "department_id")
	private Department department;

}
