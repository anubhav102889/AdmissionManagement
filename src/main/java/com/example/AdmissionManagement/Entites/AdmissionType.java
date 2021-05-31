package com.example.AdmissionManagement.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admissiontype")
public class AdmissionType {
	
	@Id
	@Column(name = "typeId")
	@Min(value = 1, message = "TypeId should be a positive value")
	@NotNull
	private Integer typeId;
	
	@Column(name = "typeName")
	private String typeName;
	
	@Column(name="percentAllocated")
	private Integer percentAllocated;
	
	@OneToOne(mappedBy = "admissionType")
	@JsonIgnore
	private Student student;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

	public Integer getPercentAllocated() {
		return percentAllocated;
	}

	public void setPercentAllocated(Integer percentAllocated) {
		this.percentAllocated = percentAllocated;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
