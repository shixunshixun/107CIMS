package cims107.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import cims107.service.BuildingService;

import java.util.List;

import cims107.model.Building;

public class BuildingSearchAction extends ActionSupport{
	
	public String buildingname;  
	public String departmentname;  
	public String simplename;
	public String compus;
	
	List<Building> buildinglst;
    
    private BuildingService buildingService;  
      
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
        
    	buildinglst = buildingService.find(buildingname, departmentname, simplename, compus);
    	    	  	
    	if(buildinglst != null) {
    		System.out.print(buildinglst.get(0).getBuildingCompus());
    		ActionContext.getContext().getSession().put("buildinglst", buildinglst);
    	   	return SUCCESS;
    	}
    	else {
    		super.addActionError("no building found");
    		return ERROR;
    	}
    }

	public List<Building> getBuildinglst() {
		return buildinglst;
	}

	public void setBuildinglst(List<Building> buildinglst) {
		this.buildinglst = buildinglst;
	}  
     
    
}
