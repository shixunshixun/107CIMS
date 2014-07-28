package cims107.action;

import java.util.List;

import net.sf.json.JSONObject;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomCreateAction extends ActionSupport implements ModelDriven<Classroom>{
	
	public String buildingname;
	public String compus;
	
	private Classroom classroom;
    private String result;
	private ClassroomService classroomService;
	BuildingService buildingService;
	public BuildingService getBuildingService() {
		return buildingService;
	}
	
	@Override
    public Classroom getModel() {
    	if(classroom == null) {
    		classroom = new Classroom();
    	}
    	return classroom;
    }

	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
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

		building = buildingService.find(buildingname, compus);
		
		if(building == null) {
			return ERROR;  //this place should raise exception or set error message
		}
		else {
			if (isValidate()) {
				
		    	//classroom.setClsBuildingId(building.getBuildingId());
				classroom.setBuilding(building);
		    	classroomService.add(classroom);
		    	result = JSONObject.fromObject("{\"success\":1}").toString();
		    	
		    	return SUCCESS;
			}
			result = JSONObject.fromObject("{\"hint\":\"Please check your input\"}").toString();
			return "hint";
		}
	}
	
	
	public Boolean isValidate() {
		
		if (classroom.getClsType().isEmpty() || classroom.getClsSerialNumber().isEmpty() || classroom.getClsClassNum() == 0 || 
				classroom.getClsUsage().isEmpty() || classroom.getClsSeatNum() == 0 || 
				classroom.getClsAvailableSeatNum() == 0) {
			return false;
		}
		
//		int commapos, hx=0, hy=0, vx=0, vy=0;
//		Boolean hflag = false, vflag = false;
//		String hcorridorlocatex, hcorridorlocatey, vcorridorlocatex, vcorridorlocatey;
		
		if(!(classroom.getClsHCorridorLocate() == null || classroom.getClsHCorridorLocate().isEmpty())) {
			for(String s1 : classroom.getClsHCorridorLocate().split(";")) {
				if(!s1.isEmpty()){
					String[] s = s1.split(",");
					int[] h = new int[2];
					for(int i = 0; i < s.length; i++) {
						if(!s[i].isEmpty()) {
							h[i] = Integer.parseInt(s[i]);
						}
						else {
							return false;
						}
					}
					if(h[1] - h[0] < 1 || h[1] > classroom.getClsMaxRow() || h[0] < 1) 
						return false;
				}
				else {
					return false;
				}
			}
		}
		
		if(!(classroom.getClsVCorridorLocate() == null || classroom.getClsVCorridorLocate().isEmpty())) {
			for(String s1 : classroom.getClsVCorridorLocate().split(";")) {
				if(!s1.isEmpty()){
					String[] s = s1.split(",");
					int[] h = new int[2];
					for(int i = 0; i < s.length; i++) {
						if(!s[i].isEmpty()) {
							h[i] = Integer.parseInt(s[i]);
						}
						else {
							return false;
						}
					}
					if(h[1] - h[0] < 1 || h[1] > classroom.getClsMaxCol() || h[0] < 1) 
						return false;
				}
				else {
					return false;
				}
			}
		}
		
//		for (int i = 0; i < classroom.getClsHCorridorLocate().length();i ++) {
//			if (classroom.getClsHCorridorLocate().charAt(i) == ',') {
//				hcorridorlocatex = classroom.getClsHCorridorLocate().substring(0, i);
//				hcorridorlocatey = classroom.getClsHCorridorLocate().substring(i+1);
//				hx = new Integer (hcorridorlocatex);
//				hy = new Integer (hcorridorlocatey);
//				hflag = true;
//			}
//		}
//		
//		for (int i = 0; i < classroom.getClsVCorridorLocate().length();i ++) {
//			if (classroom.getClsVCorridorLocate().charAt(i) == ',') {
//				vcorridorlocatex = classroom.getClsVCorridorLocate().substring(0, i);
//				vcorridorlocatey = classroom.getClsVCorridorLocate().substring(i+1);
//				vx = new Integer (vcorridorlocatex);
//				vy = new Integer (vcorridorlocatey);
//				vflag = true;
//			}
//		}
//		
//		
//		
//		if (!hflag || !vflag)
//			return false;
//		
//		if (hflag && vflag) {
//			if ((hy-hx)!=1 || (vy-vx)!=1 || hy > classroom.getClsMaxRow() || vy > classroom.getClsMaxCol() || hx < 1 || vx < 1) {
//				return false;
//			}
//		}
		
		if (classroom.getClsSeatNum() < classroom.getClsAvailableSeatNum())
			return false;
		
		if(classroom.getClsClassNum() > classroom.getClsAvailableSeatNum())
			return false;
		
		if(classroom.getClsExamNum() > classroom.getClsAvailableSeatNum())
			return false;
		
		return true;
	}
}
