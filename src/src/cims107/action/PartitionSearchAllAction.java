package cims107.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.service.PartitionService;

public class PartitionSearchAllAction extends ActionSupport{
	private PartitionService partitionService;
	private String result;
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PartitionSearchAllAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
    
    public String execute() {
    	List<Partition> allPartitionlst = partitionService.find();
    	
    	if(allPartitionlst != null) {
	    	/*JSONArray ja = new JSONArray();
	    	for(int i = 0; i < allPartitionlst.size(); i++) {
	    		Partition p = allPartitionlst.get(i);
	    		p.getClassroom().getBuilding().setClassrooms(null);
	    		p.getClassroom().setPartitions(null);
	    		
	    		ja.add(JSONObject.fromObject(p));
	    	}
	    	result = ja.toString();*/
    		JSONArray ja = new JSONArray();
	    	
    		
	    	JsonConfig jc1 = new JsonConfig();
	    	jc1.registerJsonValueProcessor(Classroom.class, new JsonValueProcessor() {
	    		@Override
	    		public Object processObjectValue(String key, Object value, JsonConfig arg2) {
	    			if(key.equals("classroom")) {
	    				Classroom b = (Classroom)value;
	    				Classroom c = new Classroom();
	    				c.setClsArea(b.getClsArea());
	    				c.setClsAvailableSeatNum(b.getClsAvailableSeatNum());
	    				c.setClsClassNum(b.getClsClassNum());
	    				c.setClsExamNum(b.getClsExamNum());
	    				c.setClsFloor(b.getClsFloor());
	    				c.setClsHasMicrophone(b.getClsHasMicrophone());
	    				c.setClsHCorridorLocate(b.getClsHCorridorLocate());
	    				c.setClsId(b.getClsId());
	    				c.setClsIsAmphi(b.getClsIsAmphi());
	    				c.setClsIsUsed(b.getClsIsUsed());
	    				c.setClsLocation(b.getClsLocation());
	    				c.setClsMaxCol(b.getClsMaxCol());
	    				c.setClsMaxRow(b.getClsMaxRow());
	    				c.setClsSeatNum(b.getClsSeatNum());
	    				c.setClsSerialNumber(b.getClsSerialNumber());
	    				c.setClsShape(b.getClsShape());
	    				c.setClsType(b.getClsType());
	    				c.setClsUsage(b.getClsUsage());
	    				c.setClsVCorridorLocate(b.getClsVCorridorLocate());
	    				c.setPartitions(null);
	    				b.setPartitions(null);
	    				//System.out.println(JSONObject.fromObject(b).toString());
	    				//System.out.println(b.getBuildingCompus());
	    				
	    				JsonConfig jc = new JsonConfig();
	    		    	jc.registerJsonValueProcessor(Building.class, new JsonValueProcessor() {
	    		    		@Override
	    		    		public Object processObjectValue(String key, Object value, JsonConfig arg2) {
	    		    			if(key.equals("building")) {
	    		    				Building d = (Building)value;
	    		    				Building e = new Building();
	    		    				e.setBuildingCompus(d.getBuildingCompus());
	    		    				e.setBuildingDepartment(d.getBuildingDepartment());
	    		    				e.setBuildingFloorNum(d.getBuildingFloorNum());
	    		    				e.setBuildingId(d.getBuildingId());
	    		    				e.setBuildingName(d.getBuildingName());
	    		    				e.setBuildingSimpleName(d.getBuildingSimpleName());
	    		    				e.setClassrooms(null);
	    		    				d.setClassrooms(null);
	    		    				//System.out.println(JSONObject.fromObject(b).toString());
	    		    				//System.out.println(b.getBuildingCompus());
	    		    				return JSONObject.fromObject(e).toString();
	    		    			}
	    		    			return value;
	    		    		}
	    		    		
	    		    		@Override  
	    		            public Object processArrayValue(Object value, JsonConfig arg1) {  
	    		                // TODO Auto-generated method stub  
	    		                return value;  
	    		            }  
	    		    	});
	    		    	
	    				return JSONObject.fromObject(c, jc).toString();
	    			}
	    			return value;
	    		}
	    		
	    		@Override  
	            public Object processArrayValue(Object value, JsonConfig arg1) {  
	                // TODO Auto-generated method stub  
	                return value;  
	            }  
	    	});

	    	for(int i = 0; i < allPartitionlst.size(); i++) {
	    		Partition p = allPartitionlst.get(i);
	    		
	    		//p.getClassroom().getBuilding().setClassrooms(null);
	    		//p.getClassroom().setPartitions(null);
	    		
	    		ja.add(JSONObject.fromObject(p, jc1));
	    	}
	    	result = ja.toString();
    	}
    	else {
    		result = "";
    	}
    	
    	return SUCCESS;
    }
}
