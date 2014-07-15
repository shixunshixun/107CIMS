package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingUpdateAction extends ActionSupport{
	
	public int buildingid;
	public String buildingname;  
	public String departmentname;  
	public String simplename;
	public String compus;
	public int floor;
    
    private BuildingService buildingService;  
      
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

	public String execute()  
    {  
        
    	Building building = new Building();
    	building.setBuildingName(buildingname);
    	building.setBuildingDepartment(departmentname);
    	building.setBuildingSimpleName(simplename);
    	building.setBuildingCompus(compus);
    	building.setBuildingFloorNum(floor);
    	
    	if(buildingService.update(buildingid, building)) {
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("update failed");
    		return ERROR;
    	}
    	
    	
    }
}
