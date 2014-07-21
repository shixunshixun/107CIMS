package cims107.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cims107.model.Building;
import cims107.service.BuildingService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BuildingUpdateAction extends ActionSupport implements ModelDriven<Building>{
	
	public int buildingid;
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
      
    public int getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(int buildingid) {
		this.buildingid = buildingid;
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
    	if(buildingService.update(buildingid, building)) {
    		result = JSONObject.fromObject(1).toString();
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("update failed");
    		return ERROR;
    	}
    }
}
