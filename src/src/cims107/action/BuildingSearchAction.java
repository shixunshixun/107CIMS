package cims107.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cims107.service.BuildingService;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cims107.model.Building;

public class BuildingSearchAction extends ActionSupport implements ModelDriven<Building>{
	
	private Building building;
	private JSONArray result;   
    private BuildingService buildingService;  
      
    @Override
    public Building getModel() {
    	if(building == null) {
    		building = new Building();
    	}
    	return building;
    }

	public BuildingSearchAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
      
    public String execute()  
    {  
        
    	List<Building> buildinglst = buildingService.find(building.getBuildingName(), building.getBuildingDepartment(), 
    			building.getBuildingSimpleName(), building.getBuildingCompus());
    	
    	if(buildinglst != null) {
	    	JSONArray ja = new JSONArray();
	    	for(int i = 0; i < buildinglst.size(); i++) {
	    		Building b = buildinglst.get(i);
	    		b.setClassrooms(null);
	    		ja.add(JSONObject.fromObject(b));
	    	}
	    	result = ja;
    	}
    	else {
    		result = null;
    	}
    	
    	return SUCCESS;
    }

	
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

}
