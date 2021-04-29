package com.example.AdmissionManagement.Entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@Column(name = "deptId")
	@NotNull(message = "DeptId cannot be null")
	@Min(value = 1, message = "DeptId should be a positive value")
	private Integer id;
	
	@Column(name = "deptName")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
	@JsonIgnore
	private List<Student> stuList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
	
}
