package cims107.action;

import net.sf.json.JSONObject;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomUpdateAction extends ActionSupport implements ModelDriven<Classroom>{
	
	/*public String buildingname;
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
	public String departmentname; */
	
	/*public String buildingname;
	public String compus;
	public String departmentname;*/
	
	private ClassroomService classroomService;
	BuildingService buildingService;
	private Classroom classroom;
    private String result;
    
    @Override
    public Classroom getModel() {
    	if(classroom == null) {
    		classroom = new Classroom();
    	}
    	return classroom;
    }
	
	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

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

	public String int2CorridorString(int x, int y) {
		String result;
		result = String.valueOf(x)+","+String.valueOf(y);
		return result;
	}
	
	public String execute() {
		//Classroom c = new Classroom();
		//Building building = new Building();
		
		/*classroom.getBuilding().setBuildingName(buildingname);
		classroom.getBuilding().setBuildingCompus(compus);
		classroom.getBuilding().setBuildingDepartment(departmentname);*/
		//building = buildingService.find(classroom.getBuilding().getBuildingName(), classroom.getBuilding().getBuildingCompus());
		
    	//classroom.setClsBuildingId(building.getBuildingId());
		//classroom.setBuilding(building);
		
		classroomService.update(classroom);
		result = JSONObject.fromObject("{\"success\":1}").toString();
		return SUCCESS;
	}
}
