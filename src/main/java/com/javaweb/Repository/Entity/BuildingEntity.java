package com.javaweb.Repository.Entity;

public class BuildingEntity {
	private String name;
	private Integer NOB;
	private String ward;
	private String street;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNOB() {
		return NOB;
	}

	public void setNOB(Integer nOB) {
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
