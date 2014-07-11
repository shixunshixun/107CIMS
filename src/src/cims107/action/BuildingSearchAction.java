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
    	
    	
    	
    	List<Building> buildinglst;
    	
    	buildinglst = buildingService.find(buildingname, departmentname, simplename, compus);
    	ActionContext.getContext().getSession().put("buildinglst", buildinglst);
    	
    	return SUCCESS;
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
