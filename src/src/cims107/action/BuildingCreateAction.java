package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class BuildingCreateAction extends ActionSupport{
	
	public String buildingname;  
	public String departmentname;  
	public String simplename;
	public String compus;
	public int floor;
    
    private BuildingService buildingService;  
      
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
    	
    	Building building = new Building();
    	building.setBuildingName(buildingname);
    	building.setBuildingDepartment(departmentname);
    	building.setBuildingSimpleName(simplename);
    	building.setBuildingCompus(compus);
    	building.setBuildingFloorNum(floor);
    	
    	if(buildingService.add(building)){
    	   	return SUCCESS;
    	}
    	else{
    		super.addActionError("update failed");
    		return ERROR;    		
    	}
    }  
   
}
