package com.spring.rest.api.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class EmployeeDAO {

	private String empName;

	private String deptName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "EmployeeDAO [empName=" + empName + ", deptName=" + deptName + "]";
	}

}
