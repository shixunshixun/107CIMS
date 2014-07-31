package cims107.action;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cims107.model.Building;
import cims107.service.BuildingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BuildingUpdateAction extends ActionSupport implements ModelDriven<Building>{
	
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
    
    public BuildingUpdateAction()  
    {  
        System.out.println("initialize BuildingUpdateAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    } 

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute()  
    {  
		if (isValidate()) {
			try {
		    	if(buildingService.update(building)) {
		    		result = JSONObject.fromObject("{\"success\":1}").toString();
		    		return SUCCESS;
		    	}
		    	else {
		    		//super.addActionError("update failed");
		    		return ERROR;
		    	}
			}
			catch(Exception e) {
				result = JSONObject.fromObject("{\"error\":\"¸üÐÂÊ§°Ü\"}").toString();
	    		return SUCCESS;
			}
		}
		result = JSONObject.fromObject("{\"hint\":\"Please check your input!\"}").toString();
		return "hint";
    }
	
	public Boolean isValidate() {
		
		if (!building.getBuildingCompus().isEmpty() && !building.getBuildingDepartment().isEmpty() && 
				!building.getBuildingName().isEmpty() && building.getBuildingFloorNum() > 0) {
			return true;
		}
		return false;
	}
}
