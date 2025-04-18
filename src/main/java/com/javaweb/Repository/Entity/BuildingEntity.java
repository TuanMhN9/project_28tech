package com.javaweb.Repository.Entity;

public class BuildingEntity {
	private String name;
	private Long NOB;
	private String ward;
	private String street;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNOB() {
		return NOB;
	}

	public void setNOB(Long nOB) {
		NOB = nOB;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
