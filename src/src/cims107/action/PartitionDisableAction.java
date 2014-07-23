package cims107.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;

public class PartitionDisableAction extends ActionSupport{
	private PartitionService partitionService;
	private String result;
	public String[] partitionid;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PartitionDisableAction()  
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
    	
    	partitionService.disableUpdate(partitionidlst);
    	result = JSONObject.fromObject("{\"success\":1}").toString();
		
		return SUCCESS;
	}
}
