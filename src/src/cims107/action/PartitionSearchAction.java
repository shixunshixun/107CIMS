package cims107.action;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cims107.model.Partition;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PartitionSearchAction extends ActionSupport implements ModelDriven<Partition>{
	/*public String pyear;
	public String buildingname;
	public String pterm;
	public String serialnumber;
	public String pdepartmentname;
	public String type;
	public String compus;
	public int maxavailableseat;
	public int minavailableseat;
	public int maxclassnum;
	public int minclassnum;
	public int maxexamnum;
	public int minexamnum;
	public int beginweek;
	public int endweek;
	public int pisused;*/
	
	private PartitionService partitionService;
	private String result;
	private Partition partition;
	
	public int maxavailableseat;
	public int minavailableseat;
	public int maxclassnum;
	public int minclassnum;
	public int maxexamnum;
	public int minexamnum;
	public String buildingname;
	public String serialnumber;	
	public String compus;

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

	public PartitionSearchAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
    
    public String execute() {
    	
    	if (isValidate()) {
    		//partition.getClassroom().setClsSerialNumber(serialnumber);
    		//partition.getClassroom().getBuilding().setBuildingCompus(compus);
    		//partition.getClassroom().getBuilding().setBuildingName(buildingname);
    		
	    	List<Partition> partitionlst = partitionService.find(partition.getPartitionYear(), compus, buildingname, partition.getPartitionTerm(), serialnumber, 
	    			partition.getPartitionDepartment(), partition.getClassroom().getClsType(), maxavailableseat, minavailableseat, 
	    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
	    			partition.getPartitionBeginWeek(), partition.getPartitionEndWeek(), partition.getPartitionIsUsed());
	    	
	    	if(partitionlst != null) {
		    	JSONArray ja = new JSONArray();
		    	for(int i = 0; i < partitionlst.size(); i++) {
		    		Partition p = partitionlst.get(i);
		    		p.getClassroom().getBuilding().setClassrooms(null);
		    		p.getClassroom().setPartitions(null);
		    		ja.add(JSONObject.fromObject(p));
		    	}
		    	result = ja.toString();
	    	}
	    	else {
	    		result = "";
	    	}
	    	return SUCCESS;
    	}
    	return ERROR;
    }
    
    public Boolean isValidate() {
    	return (maxavailableseat >= minavailableseat && maxclassnum >= minclassnum 
    			&& maxexamnum >= minexamnum && partition.getPartitionBeginWeek() <= partition.getPartitionEndWeek());
    }
}
