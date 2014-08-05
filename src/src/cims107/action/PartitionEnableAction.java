package cims107.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;

public class PartitionEnableAction extends ActionSupport{
	private JSONObject result;
	private PartitionService partitionService;
	public String[] partitionid;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public PartitionEnableAction()  
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
    	
    	partitionService.enabeUpdate(partitionidlst);
    	result = JSONObject.fromObject("{\"success\":\"ÒÑÆôÓÃ\"}");
		
		return SUCCESS;
	}
}
