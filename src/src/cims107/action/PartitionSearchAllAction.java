package cims107.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

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
	    	JSONArray ja = new JSONArray();
	    	for(int i = 0; i < allPartitionlst.size(); i++) {
	    		Partition p = allPartitionlst.get(i);
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
}
