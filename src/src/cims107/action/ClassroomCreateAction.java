package cims107.action;

import java.util.List;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomCreateAction extends ActionSupport{
	public String buildingname;
	public String serialnumber;
	public String compus;
	public int floor;
	public String type;
	public String shape;
	public int classnum;
	public int examnum;
	public int maxrow;
	public int maxcol;
	public String hcorridorlocate;
	public String vcorridorlocate;
	public int area;
	public String location;
	public Boolean isamphi;
	public Boolean hasmicrophone;
	public Boolean isused;
	public String usage;
	public int seatnum;
	public int availableseatnum;
	
	private ClassroomService classroomService;
	
	public ClassroomCreateAction()  
    {  
        System.out.println("initialize ClassroomCreateAction......");  
    }
	
	public void setClassroomService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
    }
	
	public String execute()
	{
		Building building = new Building();
		BuildingService buildingService = new BuildingService();
		
		building = buildingService.find(buildingname, compus);
		
		if(building == null) {
			return ERROR;  //this place should raise exception or set error message
		}
		else {
			
			Classroom classroom = new Classroom();
	    	classroom.setClsSerialNumber(serialnumber);
	    	classroom.setClsFloor(floor);
	    	classroom.setClsType(type);
	    	classroom.setClsShape(shape);
	    	classroom.setClsClassNum(classnum);
	    	classroom.setClsExamNum(examnum);
	    	classroom.setClsMaxRow(maxrow);
	    	classroom.setClsMaxCol(maxcol);
	    	classroom.setClsHCorridorLocate(hcorridorlocate);
	    	classroom.setClsVCorridorLocate(vcorridorlocate);
	    	classroom.setClsArea(area);
	    	classroom.setClsLocation(location);
	    	classroom.setClsIsAmphi(isamphi);
	    	classroom.setClsHasMicrophone(hasmicrophone);
	    	classroom.setClsIsUsed(isused);
	    	classroom.setClsUsage(usage);
	    	classroom.setClsSeatNum(seatnum);
	    	classroom.setClsAvailableSeatNum(availableseatnum);
	    	classroom.setClsBuildingId(building.getBuildingId());
	    	
	    	classroomService.add(classroom);
	    	
	    	return "ADDSUCCESS";
		}
	}
}
