package cims107.action;

import java.util.ArrayList;
import java.util.List;

import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomDeleteAction extends ActionSupport{
	public String[] clsid;
	
	private ClassroomService classroomService;
	
	public ClassroomDeleteAction()  
    {  
        System.out.println("initialize BuildingDeletesAction......");  
    }
    
	public void setClassroomService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
    }

	public String[] getClsid() {
		return clsid;
	}

	public void setClsid(String[] clsid) {
		this.clsid = clsid;
	}
	
	public String execute() {
		List<Integer> clsidlst = new ArrayList<Integer>();
    	
		//auto conversion??
    	for(int i=0; i<clsid.length;i++){
    		clsidlst.add(new Integer (clsid[i]));
    	}
    	
    	if(classroomService.delete(clsidlst)){
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("delete failed");
    		return ERROR;
    	}
	}
}
