package cims107.action;

import java.util.*;

import cims107.model.Partition;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;

public class PartitionSearchAction extends ActionSupport{
	private PartitionService partitionService;
	private List<Partition> partitionlst;
	
	public String pyear;
	public String buildingname;
	public String pterm;
	public String serialnumber;
	public String departmentname;
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
	public int pisused;
	

	public List<Partition> getPartitionlst() {
		return partitionlst;
	}

	public void setPartitionlst(List<Partition> partitionlst) {
		this.partitionlst = partitionlst;
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
	    	partitionlst = partitionService.find(pyear, compus, buildingname, pterm, serialnumber, 
	    			departmentname, type, maxavailableseat, minavailableseat, 
	    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
	    			beginweek, endweek, pisused);
	    	
	    	return SUCCESS;
    	}
    	return ERROR;
    }
    
    public Boolean isValidate() {
    	return (maxavailableseat >= minavailableseat && maxclassnum >= minclassnum 
    			&& maxexamnum >= minexamnum && beginweek <= endweek);
    }
}
