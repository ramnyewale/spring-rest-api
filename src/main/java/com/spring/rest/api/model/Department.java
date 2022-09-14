package com.spring.rest.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_department")
public class Department implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 2749697544707575463L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String deptName;

}
