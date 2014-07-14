package cims107.action;

import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class SeatManageAction extends ActionSupport{
	public int clsid;
	
	private ClassroomService classroomService;
	
	public SeatManageAction() 
    {  
        System.out.println("initialize ClassroomCreateAction......");  
    }
	
	public void setClassroomService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
    }
	
	public int getClsid() {
		return clsid;
	}

	public void setClsid(int clsid) {
		this.clsid = clsid;
	}
	
	public String execute() {
		return SUCCESS;
	}
}
