package com.example.AdmissionManagement.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId")
	private Integer studentId;
	
	@Column(name = "studentName")
	@NotEmpty(message = "name cannot be empty")
	private String studentName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stuDeptId",referencedColumnName = "deptId",nullable = false)
	@Valid
	@NotNull
	private Department department;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stuAdmissTypeId",referencedColumnName = "typeId",nullable = false)
	@NotNull
	@Valid
	private AdmissionType admissionType;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public AdmissionType getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(AdmissionType admissionType) {
		this.admissionType = admissionType;
	}
	
}
