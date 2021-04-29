package com.example.AdmissionManagement.Pojos;

public class SeatAvailablePojo {
	
	private Integer deptId;
	
	private Integer typeId;
	
	private Integer seatsAvailable;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public SeatAvailablePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatAvailablePojo(Integer deptId, Integer typeId, Integer seatsAvailable) {
		super();
		this.deptId = deptId;
		this.typeId = typeId;
		this.seatsAvailable = seatsAvailable;
	}
	
	

}
