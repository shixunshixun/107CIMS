package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BuildingCreateAction extends ActionSupport implements ModelDriven<Building>{
	
    private Building building;
    private JSONObject result;
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
    	if (isValidate()) {
    		try {
		    	if(buildingService.add(building)){
		    		result = JSONObject.fromObject("{\"success\":\"新增成功\"}");
		    	   	return SUCCESS;
		    	}
		    	else{
		    		//super.addActionError("update failed");
		    		return ERROR;
		    	}
    		}
    		catch(Exception e) {
    			result = JSONObject.fromObject("{\"error\":\"新增失败\"}");
	    	   	return SUCCESS;
    		}
    	}
    	result = JSONObject.fromObject("{\"hint\":\"The input is invalid\"}");
    	return "hint";
    } 

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	public Boolean isValidate() {
		if (!building.getBuildingCompus().isEmpty() && !building.getBuildingDepartment().isEmpty() && 
				!building.getBuildingName().isEmpty() && building.getBuildingFloorNum() > 0) {
			return true;
		}
		return false;
	}
}
