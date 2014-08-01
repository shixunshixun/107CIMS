package cims107.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import cims107.service.PartitionService;

public class PartitionDeleteAction extends ActionSupport{
	private PartitionService partitionService;
	public String[] partitionid;
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public PartitionDeleteAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
    
    public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
    
    public String[] getPartitionid() {
		return partitionid;
	}

	public void setPartitionid(String[] partitionid) {
		this.partitionid = partitionid;
	}

	public String execute() {
    	List<Integer> partitionidlst = new ArrayList<Integer>();
    	
    	for(int i=0; i<partitionid.length;i++){
    		partitionidlst.add(new Integer (partitionid[i]));
    	}
    	
    	try {
	    	if(partitionService.delete(partitionidlst)){
	    		result = JSONObject.fromObject("{\"success\":1}");
	    		return SUCCESS;
	    	}
	    	else {
	    		//super.addActionError("delete failed");
	    		return ERROR;
	    	}
    	}
    	catch(Exception e) {
    		result = JSONObject.fromObject("{\"error\":\"É¾³ýÊ§°Ü\"}");
    		return SUCCESS;
    	}
    }
}
