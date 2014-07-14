package cims107.model;

public class Building {
	private int buildingId;
	private String buildingName;  
	private String buildingDepartment;  
	private String buildingSimpleName;
	private String buildingCompus;
	private int buildingFloorNum;
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingDepartment() {
		return buildingDepartment;
	}
	public void setBuildingDepartment(String buildingDepartment) {
		this.buildingDepartment = buildingDepartment;
	}
	public String getBuildingSimpleName() {
		return buildingSimpleName;
	}
	public void setBuildingSimpleName(String buildingSimpleName) {
		this.buildingSimpleName = buildingSimpleName;
	}
	public String getBuildingCompus() {
		return buildingCompus;
	}
	public void setBuildingCompus(String buildingCompus) {
		this.buildingCompus = buildingCompus;
	}
	public int getBuildingFloorNum() {
		return buildingFloorNum;
	}
	public void setBuildingFloorNum(int buildingFloorNum) {
		this.buildingFloorNum = buildingFloorNum;
	}	
}
