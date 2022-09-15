package com.spring.rest.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spring.rest.api.dao.EmployeeDAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

	public EmpDeptMapping(EmployeeDAO dao) {
		this.empName = dao.getEmpName();
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "EmpDeptMapping [empId=" + empId + ", empName=" + empName + ", department=" + department + "]";
	}

}
