package cims107.model;

public class Building {
	private int buildingId;
	private String buildingname;  
	private String departmentname;  
	private String simplename;
	private String compus;
	private int floor;
	
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingname() {
		return buildingname;
	}
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getSimplename() {
		return simplename;
	}
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	public String getCompus() {
		return compus;
	}
	public void setCompus(String compus) {
		this.compus = compus;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
}
