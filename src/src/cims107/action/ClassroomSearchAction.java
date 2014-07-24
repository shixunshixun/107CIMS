package cims107.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassroomSearchAction extends ActionSupport implements ModelDriven<Classroom>{
	private Classroom classroom;
    private String result;
	public int maxClassNum;
	public int minClassNum;
	public int maxExamNum;
	public int minExamNum;
	public String compus;
	public String departmentname;
	public String buildingname;
	
	
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
		//if (isValidate()) {
			//classroom.getBuilding().setBuildingName(buildingname);
			//classroom.getBuilding().setBuildingCompus(compus);
			//classroom.getBuilding().setBuildingDepartment(departmentname);
			
			List<Classroom> classroomlst = classroomService.find(compus, departmentname, classroom.getClsType(), buildingname, 
					classroom.getClsFloor(), classroom.getClsSerialNumber(), minClassNum, maxClassNum, 
					classroom.getClsArea(), minExamNum, maxExamNum, classroom.getClsLocation(), 
					classroom.getClsIsAmphi(), classroom.getClsShape(), classroom.getClsHasMicrophone(), classroom.getClsUsage(), classroom.getClsIsUsed());
			
			if(classroomlst != null) {
				JSONArray ja = new JSONArray();
		    	JsonConfig jc = new JsonConfig();
		    	jc.registerJsonValueProcessor(Building.class, new JsonValueProcessor() {
		    		@Override
		    		public Object processObjectValue(String key, Object value, JsonConfig arg2) {
		    			if(key.equals("building")) {
		    				Building b = (Building)value;
		    				Building c = new Building();
		    				c.setBuildingCompus(b.getBuildingCompus());
		    				c.setBuildingDepartment(b.getBuildingDepartment());
		    				c.setBuildingFloorNum(b.getBuildingFloorNum());
		    				c.setBuildingId(b.getBuildingId());
		    				c.setBuildingName(b.getBuildingName());
		    				c.setBuildingSimpleName(b.getBuildingSimpleName());
		    				c.setClassrooms(null);
		    				b.setClassrooms(null);
		    				//System.out.println(JSONObject.fromObject(b).toString());
		    				//System.out.println(b.getBuildingCompus());
		    				return JSONObject.fromObject(c).toString();
		    			}
		    			return value;
		    		}
		    		
		    		@Override  
		            public Object processArrayValue(Object value, JsonConfig arg1) {  
		                // TODO Auto-generated method stub  
		                return value;  
		            }  
		    	});

		    	for(int i = 0; i < classroomlst.size(); i++) {
		    		Classroom c = classroomlst.get(i);
		    		c.setPartitions(null);
		    		//c.setBuilding(null);
		    		//c.getBuilding().setClassrooms(null);
		    		ja.add(JSONObject.fromObject(c, jc));
		    	}
		    	result = ja.toString();
	    	}
	    	else {
	    		result = "";
	    	}
	    	
	    	return SUCCESS;
			
			//��ʾ��ȡ���Ľ�����Ϣ
		//}
	}
	
	public Boolean isValidate() {
		return (maxClassNum >= minClassNum) && (maxExamNum >= minExamNum) && (minClassNum > 0) && (minExamNum > 0);
	}
}
