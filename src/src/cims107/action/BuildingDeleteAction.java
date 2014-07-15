package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class BuildingDeleteAction extends ActionSupport{
	
	public String[] buildingid;
	
    private BuildingService buildingService;  
      
    public BuildingDeleteAction()  
    {  
        System.out.println("initialize BuildingDeletesAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
    
    
    public String[] getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String[] buildingid) {
		this.buildingid = buildingid;
	}

	public String execute()  
    {  
        
    	List<Integer> buildingidlst = new ArrayList<Integer>();
    	
    	//auto convert?
    	for(int i=0; i<buildingid.length;i++){
    		buildingidlst.add(new Integer (buildingid[i]));
    	}
    	
    	if(buildingService.delete(buildingidlst)){
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("delete failed");
    		return ERROR;
    	}
    }
}
