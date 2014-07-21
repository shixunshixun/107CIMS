package cims107.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;
import cims107.service.PartitionService;

public class PartitionCreateAction extends ActionSupport{
	public String pyear;
	public String buildingname;
	public String compus;
	public String pterm;
	public String serialnumber;
	public String pdepartmentname;
	public String type;
	public int maxavailableseat;
	public int minavailableseat;
	public int pclassnum;
	public int pexamnum;
	public int beginweek;
	public int endweek;
	public String begindate;
	public String enddate;
	public int beginlession;
	public int endlession;
	public int pisused;
	
	public String[] whichday; 
	
	private PartitionService partitionService;
	BuildingService buildingService;
	ClassroomService classroomService;
	
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
	    	
	    	Partition partition = new Partition();
	    	Building building = new Building();
			building = buildingService.find(buildingname, compus);
			Classroom classroom = new Classroom();
			classroom = classroomService.find(building.getBuildingId(), serialnumber);
	    	
	    	partition.setPartitionYear(pyear);
	    	partition.setPartitionTerm(pterm);
	    	partition.setPartitionClsId(classroom.getClsId());
	    	partition.setPartitionDepartment(pdepartmentname);
	    	partition.setPartitionClassNum(pclassnum);
	    	partition.setPartitionExamNum(pexamnum);
	    	partition.setPartitionBeginWeek(beginweek);
	    	partition.setPartitionEndWeek(endweek);
	    	partition.setPartitionBeginDate(begindate);
	    	partition.setPartitionEndDate(enddate);
	    	partition.setPartitionBeginLession(beginlession);
	    	partition.setPartitionEndLession(endlession);
	    	partition.setPartitionWhichDay(list2WhichdayString(whichdaylst));
	    	partition.setPartitionIsUsed(pisused);
	    	
	    	partitionService.add(partition);
	    	
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
