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
      
    public String execute()  
    {  
        /*if (true == this.userService.isLogin(username, password))  
        {  
            ActionContext.getContext().getSession().put("username", username);  
            return SUCCESS;  
        }else{  
            super.addActionError(super.getText("loginfailed"));  
            return ERROR;  
        }  */
    	
    	/*ActionContext.getContext().getSession().put("buildingname", buildingname);
    	ActionContext.getContext().getSession().put("departmentname", departmentname);
    	ActionContext.getContext().getSession().put("simplename", simplename);
    	ActionContext.getContext().getSession().put("compus", compus);*/
    	
    	
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
