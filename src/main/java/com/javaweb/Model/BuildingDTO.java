package com.javaweb.Model;
// các thực thể
public class BuildingDTO {
	private String name;
	private Long NOB;
	private String adress;
	private String floorArea;

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
	
	

}
