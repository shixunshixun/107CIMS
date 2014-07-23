package cims107.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import cims107.service.PartitionService;

public class PartitionDeleteAction extends ActionSupport{
	private PartitionService partitionService;
	public String[] partitionid;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
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
    	
    	if(partitionService.delete(partitionidlst)){
    		result = JSONObject.fromObject("{\"success\":1}").toString();
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("delete failed");
    		return ERROR;
    	}
    }
}
