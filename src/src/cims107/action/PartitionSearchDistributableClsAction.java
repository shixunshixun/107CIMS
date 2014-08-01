package cims107.action;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.service.ClassroomService;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PartitionSearchDistributableClsAction extends ActionSupport implements ModelDriven<Partition>{
	
	private PartitionService partitionService;
	private JSONArray result;
	private Partition partition;
	private ClassroomService classroomService;
	
	public int maxavailableseat;
	public int minavailableseat;
	public int maxclassnum;
	public int minclassnum;
	public int maxexamnum;
	public int minexamnum;
	public String buildingname;
	public String serialnumber;	
	public String type;
	public String compus;

	@Override
    public Partition getModel() {
    	if(partition == null) {
    		partition = new Partition();
    	}
    	return partition;
    }

	public ClassroomService getClassroomService() {
		return classroomService;
	}

	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public Partition getPartition() {
		return partition;
	}

	public void setPartition(Partition partition) {
		this.partition = partition;
	}

	public PartitionSearchDistributableClsAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
    
    public String execute() {
    	
    	if (isValidate()) {
    		
    		List<Classroom> classroomlst = classroomService.find();
    		
	    	List<Partition> partitionlst = partitionService.find(partition.getPartitionYear(), compus, buildingname, partition.getPartitionTerm(), serialnumber, 
	    			partition.getPartitionDepartment(), type, maxavailableseat, minavailableseat, 
	    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
	    			partition.getPartitionBeginWeek(), partition.getPartitionEndWeek(), partition.getPartitionIsUsed());
	    	
	    	Iterator<Classroom> citer = classroomlst.iterator();
	    	Iterator<Partition> piter = partitionlst.iterator();
	    	
	    	while (citer.hasNext()) {
	    		Classroom tempc = citer.next();
	    		while (piter.hasNext()) {
	    			Partition tempp = piter.next();
	    			if (tempc.getClsId() == tempp.getClassroom().getClsId()) {
	    				citer.remove();
	    				break;
	    			}
	    		}
	    	}
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
		    	result = ja;
	    	}
	    	else {
	    		result = null;
	    	}
	    	return SUCCESS;
    	}
    	JSONArray ja = new JSONArray();
    	ja.add(JSONObject.fromObject("{\"hint\":\"Please check your search condition\"}"));
    	result = ja;
    	return "hint";
    }
    
    public Boolean isValidate() {
    	
    	if ((maxavailableseat != 0 && minavailableseat != 0 && minavailableseat > maxavailableseat) || 
				(maxclassnum != 0 && minclassnum != 0 && minclassnum > maxclassnum) || 
				(maxexamnum != 0 && minexamnum != 0 && minexamnum > maxexamnum) || 
				(!(partition.getPartitionIsUsed() >= 0 && partition.getPartitionIsUsed() <= 2)) || 
				(partition.getPartitionBeginWeek() != 0 && partition.getPartitionEndWeek() != 0 && 
					partition.getPartitionBeginWeek() > partition.getPartitionEndWeek()) || 
    				partition.getPartitionBeginWeek() < 0 || partition.getPartitionEndWeek() > 18) {
			return false;
		}
		return true;
    }
}
