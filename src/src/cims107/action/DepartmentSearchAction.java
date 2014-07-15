package cims107.action;

import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Department;
import cims107.service.DepartmentService;

public class DepartmentSearchAction extends ActionSupport{
	private DepartmentService departmentService;
	
	public String departmentname;
	public String departmentid;
	
	public DepartmentSearchAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public void setDepartmentService(DepartmentService departmentService)  
    {  
        this.departmentService = departmentService;  
    }
    
    public String execute() {
    	Department department = new Department();
    	department = departmentService.find(departmentid);
    	this.setDepartmentname(department.getDepartmentName());
    	
    	return SUCCESS;
    }
}
