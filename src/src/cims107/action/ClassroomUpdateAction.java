package cims107.action;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomUpdateAction extends ActionSupport{
	public int clsid;
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
	public int isamphi;
	public int hasmicrophone;
	public int isused;
	public String usage;
	public int seatnum;
	public int availableseatnum;
	public String departmentname; 
	
	private ClassroomService classroomService;
	BuildingService buildingService;
	
	public BuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public ClassroomUpdateAction() 
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

	public String int2CorridorString(int x, int y) {
		String result;
		result = String.valueOf(x)+","+String.valueOf(y);
		return result;
	}
	
	public String execute() {
		Classroom classroom = new Classroom();
		Building building = new Building();
		
		building = buildingService.find(buildingname, compus);
		
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
		
		classroomService.update(clsid, buildingname, departmentname, classroom);
		return SUCCESS;
	}
}
