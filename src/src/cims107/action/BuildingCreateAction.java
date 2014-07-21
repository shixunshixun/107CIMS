package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BuildingCreateAction extends ActionSupport implements ModelDriven<Building>{
	
	
    private Building building;
    private String result;
    private BuildingService buildingService; 
    
    @Override
    public Building getModel() {
    	if(building == null) {
    		building = new Building();
    	}
    	return building;
    }
    

	public BuildingCreateAction()  
    {  
        System.out.println("initialize BuildingQueryAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
      
    public String execute()  
    {
    	//JSONArray ja = new JSONArray();
    	
//    	building.setBuildingName(building.getBuildingName());
//    	building.setBuildingDepartment(building.getBuildingDepartment());
//    	building.setBuildingSimpleName(building.getBuildingSimpleName());
//    	building.setBuildingCompus(building.getBuildingCompus());
//    	building.setBuildingFloorNum(building.getBuildingFloorNum());
    	
    	
    	
    	if(buildingService.add(building)){
    		//ja.add(JSONObject.fromObject(1));
    		result = JSONObject.fromObject(1).toString();
    	   	return SUCCESS;
    	}
    	else{
    		super.addActionError("update failed");
    		return ERROR;
    	}
    }  
   
    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}
