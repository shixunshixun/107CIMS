package cims107.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;
import cims107.service.PartitionService;

public class PartitionCreateAction extends ActionSupport implements ModelDriven<Partition>{
	
	public String[] whichday; 
	public String buildingname;
	public String compus;
	public String serialnumber;
	
	private String result;
	private Partition partition;
	private PartitionService partitionService;
	BuildingService buildingService;
	ClassroomService classroomService;
	
	@Override
    public Partition getModel() {
    	if(partition == null) {
    		partition = new Partition();
    	}
    	return partition;
    }
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Partition getPartition() {
		return partition;
	}

	public void setPartition(Partition partition) {
		this.partition = partition;
	}

	public BuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public ClassroomService getClassroomService() {
		return classroomService;
	}

	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	public String[] getWhichday() {
		return whichday;
	}

	public void setWhichday(String[] whichday) {
		this.whichday = whichday;
	}

	public PartitionCreateAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
    
    public String list2WhichdayString(List<Integer> whichdaylst) {
    	String result;
    	result = String.valueOf(whichdaylst.get(0));
    	
    	for (int i = 1; i < whichdaylst.size(); i ++) {
    		result = result + "," + String.valueOf(whichdaylst.get(i));
    	}
    	
    	return result;
    }
    
    public String execute() {
    	//if (isValidate()) {
	    	List<Integer> whichdaylst = new ArrayList<Integer>();
	    	
	    	for(int i=0; i<whichday.length;i++){
	    		whichdaylst.add(new Integer (whichday[i]));
	    	}
	    	
	    	Building building = new Building();
	    	
			building = buildingService.find(buildingname, compus);
			Classroom classroom = new Classroom();
			classroom = classroomService.find(building.getBuildingId(), serialnumber);
	    	
	    	
	    	partition.setPartitionWhichDay(list2WhichdayString(whichdaylst));
	    	
	    	partition.setClassroom(classroom);
	    	partition.getClassroom().setBuilding(building);
	    	
	    	partitionService.add(partition);
	    	result = JSONObject.fromObject("{\"success\":1}").toString();
	    	
	    	return SUCCESS;
    	//}
    	//return ERROR;
    }
    
    /*public Boolean isValidate() {
    	if (maxavailableseat < minavailableseat || beginweek > endweek || 
    			beginlession < 1 || endlession > 15 || beginlession > endlession)
    		return false;
    	if (begindate.after(enddate))
    		return false;
    	return true;
    }*/
}
