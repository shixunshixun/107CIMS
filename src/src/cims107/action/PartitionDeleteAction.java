package cims107.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cims107.service.PartitionService;

public class PartitionDeleteAction extends ActionSupport{
	private PartitionService partitionService;
	public String[] partitionid;
	
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
    	
    	if(buildingService.delete(buildingidlst)){
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("delete failed");
    		return ERROR;
    	}
    	
    	return SUCCESS;
    }
}
