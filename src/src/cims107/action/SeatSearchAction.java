package cims107.action;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.model.Seat;
import cims107.service.ClassroomService;
import cims107.service.SeatManageService;

import com.opensymphony.xwork2.ActionSupport;

public class SeatSearchAction extends ActionSupport{
	private int clsid;
	private JSONArray result;
	
	private SeatManageService seatmanageService;
	
	public SeatSearchAction() 
    {  
        System.out.println("initialize ClassroomCreateAction......");  
    }
	public SeatManageService getSeatmanageService() {
		return seatmanageService;
	}
	public void setSeatmanageService(SeatManageService seatmanageService) {
		this.seatmanageService = seatmanageService;
	}
	public JSONArray getResult() {
		return result;
	}
	public void setResult(JSONArray result) {
		this.result = result;
	}
	public int getClsid() {
		return clsid;
	}

	public void setClsid(int clsid) {
		this.clsid = clsid;
	}
	
	public String execute() {
    	List<Seat> seatlst = seatmanageService.find(clsid);
    	
    	if(seatlst != null) {
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
	    				c.setBuilding(b.getBuilding());
	    				c.setPartitions(null);
	    				b.setPartitions(null);
	    				c.setSeats(null);
	    				b.setSeats(null);
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
	    		    				return JSONObject.fromObject(e);
	    		    			}
	    		    			return value;
	    		    		}
	    		    		
	    		    		@Override  
	    		            public Object processArrayValue(Object value, JsonConfig arg1) {  
	    		                // TODO Auto-generated method stub  
	    		                return value;  
	    		            }  
	    		    	});
	    		    	
	    				return JSONObject.fromObject(c, jc);
	    			}
	    			return value;
	    		}
	    		
	    		@Override  
	            public Object processArrayValue(Object value, JsonConfig arg1) {  
	                // TODO Auto-generated method stub  
	                return value;  
	            }  
	    	});
	    	
	    	for(int i = 0; i < seatlst.size(); i++) {
	    		Seat s = seatlst.get(i);
	    		ja.add(JSONObject.fromObject(s, jc1));
	    	}
	    	result = ja;
    	}
    	else {
    		result = null;
    	}
    	return SUCCESS;
	}
}
