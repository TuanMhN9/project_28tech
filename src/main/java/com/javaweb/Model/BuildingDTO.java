package com.javaweb.Model;
// các thực thể
public class BuildingDTO {
	private String name;
	private Long numberOfBasement;
	private String adress;
	private String floorArea;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
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
