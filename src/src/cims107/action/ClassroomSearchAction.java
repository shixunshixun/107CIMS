package cims107.action;

import java.util.List;

import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomSearchAction extends ActionSupport{
	public String buildingname;
	public String serialnumber;
	public String compus;
	public int floor;
	public String type;
	public String shape;
	public int area;
	public String location;
	public Boolean isamphi;
	public Boolean hasmicrophone;
	public Boolean isused;
	public String usage;
	public String departmentname; 
	public int maxClassNum;
	public int minClassNum;
	public int maxExamNum;
	public int minExamNum;
	
	private ClassroomService classroomService;
	
	public ClassroomSearchAction()  
    {  
        System.out.println("initialize ClassroomSearchAction......");  
    }
	
	public void setClassroomService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
    }
	
	public String execute()
	{
		List<Classroom> classroomlst;
		
		classroomlst = classroomService.find(compus, departmentname, type, buildingname, 
				floor, serialnumber, minClassNum, maxClassNum, 
				area, minExamNum, maxExamNum, location, 
				isamphi, shape, hasmicrophone, usage, isused);
		
		//显示获取到的教室信息
		
		
		return SUCCESS;
	}
}
