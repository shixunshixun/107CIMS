package cims107.action;


import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;

public class PartitionUpdateAction extends ActionSupport{
	public int pid;
	public String pyear;
	public String pterm;
	public int beginweek;
	public int endweek;
	public String pdepartmentname;
	
	private PartitionService partitionService;
	
	public PartitionUpdateAction() 
    {  
        System.out.println("initialize ParitionCreateAction......");  
    }
	
	public void setParitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String execute() {
		if(partitionService.update(pid, pyear, pterm, beginweek, endweek, pdepartmentname)) {
    		return SUCCESS;
    	}
    	else {
    		super.addActionError("update failed");
    		return ERROR;
    	}
	}
}
