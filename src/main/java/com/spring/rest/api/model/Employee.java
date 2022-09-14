package com.spring.rest.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employee")
public class Employee implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 5420093580469100847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Long age=0L;

	@Column(name = "location")
	private String location;

	@Email(message = "Please provide the valid email address.")
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "department")
	private String department;

	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false)
	private Date createAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + ", createAt=" + createAt + ", updatedAt=" + updatedAt + "]";
	}

}
