package com.example.AdmissionManagement.Pojos;

public class DepartStuCountInfo {
	
	private Integer deptId;
	
	private String deptName;
	
	private long noofStudents;
	
	private String deptType;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	

	public long getNoofStudents() {
		return noofStudents;
	}

	public void setNoofStudents(long noofStudents) {
		this.noofStudents = noofStudents;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public DepartStuCountInfo() {
		// TODO Auto-generated constructor stub
	}

	public DepartStuCountInfo(Integer deptId, String deptName, long noofStudents, String deptType) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.noofStudents = noofStudents;
		this.deptType = deptType;
	}

	

}
