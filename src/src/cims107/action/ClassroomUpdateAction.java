package cims107.action;

import net.sf.json.JSONObject;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomUpdateAction extends ActionSupport implements ModelDriven<Classroom>{
	
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
		if (isValidate()) {
			try {
				classroomService.update(classroom);
				result = JSONObject.fromObject("{\"success\":1}").toString();
				return SUCCESS;
			}
			catch(Exception e) {
				result = JSONObject.fromObject("{\"error\":\"¸üÐÂÊ§°Ü\"}").toString();
				return SUCCESS;
			}
		}
		result = JSONObject.fromObject("{\"hint\":\"Please check your input\"}").toString();
		return "hint";
	}
	
	public Boolean isValidate() {
		
		if (classroom.getClsType().isEmpty() || classroom.getClsSerialNumber().isEmpty() || classroom.getClsClassNum() == 0 || 
				classroom.getClsUsage().isEmpty() || classroom.getClsSeatNum() == 0 || 
				classroom.getClsAvailableSeatNum() == 0) {
			return false;
		}
			
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
					if(h[1] - h[0] == 1 || h[1] > classroom.getClsMaxRow() || h[0] < 1) 
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
					if(h[1] - h[0] == 1 || h[1] > classroom.getClsMaxCol() || h[0] < 1) 
						return false;
				}
				else {
					return false;
				}
			}
		}
		
		if (classroom.getClsFloor() <= 0 || classroom.getClsClassNum() < 0 || classroom.getClsExamNum() < 0 || 
				classroom.getClsArea() <= 0 || classroom.getClsMaxCol() <= 0 || classroom.getClsMaxRow() <= 0)
			return false;
		if (classroom.getClsSeatNum() != 0 && classroom.getClsAvailableSeatNum() != 0 && 
				classroom.getClsSeatNum() < classroom.getClsAvailableSeatNum())
			return false;
		
		if(classroom.getClsClassNum() != 0 && classroom.getClsAvailableSeatNum() != 0 && 
				classroom.getClsClassNum() > classroom.getClsAvailableSeatNum())
			return false;
		
		if(classroom.getClsExamNum() != 0 && classroom.getClsAvailableSeatNum() != 0 && 
				classroom.getClsExamNum() > classroom.getClsAvailableSeatNum())
			return false;
		
		if ((!(classroom.getClsIsAmphi() >= 0 && classroom.getClsIsAmphi() <= 2)) || 
				(!(classroom.getClsHasMicrophone() >= 0 && classroom.getClsHasMicrophone() <= 2)) || 
				(!(classroom.getClsIsUsed() >= 0 && classroom.getClsIsUsed() <= 2))) {
			return false;
		}
		
		return true;
	}
}
