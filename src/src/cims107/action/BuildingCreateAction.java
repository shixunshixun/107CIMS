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
    	building.setBuldingDepartment(departmentname);
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
     
    /*
    public void validate()  
    {  
        if ((null == username) || (0==username.length()))  
        {  
            super.addActionError(super.getText("warning.empty",new String[] {getText("username")}));  
        }  
          
        if ((null == password) || (0 == password.length()))  
        {  
            super.addActionError(super.getText("warning.empty",new String[] {getText("password")}));  
              
        }  
    }  */
}
