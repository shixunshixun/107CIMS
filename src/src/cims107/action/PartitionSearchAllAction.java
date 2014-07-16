package cims107.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Partition;
import cims107.service.PartitionService;

public class PartitionSearchAllAction extends ActionSupport{
	private PartitionService partitionService;
	private List<Partition> allPartitionlst;
	

	public List<Partition> getAllPartitionlst() {
		return allPartitionlst;
	}

	public void setAllPartitionlst(List<Partition> allPartitionlst) {
		this.allPartitionlst = allPartitionlst;
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
    	allPartitionlst = partitionService.find();
    	
    	return SUCCESS;
    }
}
