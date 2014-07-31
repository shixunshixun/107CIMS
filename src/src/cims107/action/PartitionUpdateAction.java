package cims107.action;


import net.sf.json.JSONObject;
import cims107.model.Classroom;
import cims107.model.Partition;
import cims107.service.PartitionService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PartitionUpdateAction extends ActionSupport implements ModelDriven<Partition>{
	
	private String result;
	private Partition partition;
	private PartitionService partitionService;
	
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

	public PartitionUpdateAction() 
    {  
        System.out.println("initialize ParitionCreateAction......");  
    }
	
	public void setPartitionService(PartitionService partitionService)  
    {  
        this.partitionService = partitionService;  
    }

	public String execute() {
		if (isValidate()) {
			if(partitionService.update(partition)) {	
				result = JSONObject.fromObject("{\"success\":1}").toString();
	    		return SUCCESS;
	    	}
	    	else {
	    		super.addActionError("update failed");
	    		return ERROR;
	    	}
		}
		result = JSONObject.fromObject("{\"hint\":\"Please check your input\"}").toString();
		return "hint";
	}
	
	public Boolean isValidate() {
		if (partition.getPartitionYear().isEmpty() || partition.getPartitionTerm().isEmpty() || 
				partition.getPartitionDepartment().isEmpty()) {
			return false;
		}
		
		if (partition.getPartitionBeginDate() != null && partition.getPartitionEndDate() != null) {
	    	if (partition.getPartitionBeginWeek() != 0 && partition.getPartitionEndWeek() != 0) {
	    		if (!partition.getPartitionBeginDate().isEmpty() || !partition.getPartitionEndDate().isEmpty())
	    			return false;
	    		if (partition.getPartitionBeginWeek() > partition.getPartitionEndWeek() || 
	    				partition.getPartitionBeginWeek() < 1 || partition.getPartitionEndWeek() > 18)
	    			return false;
	    		return true;
	    	}
    	}
    	if (partition.getPartitionBeginWeek() == 0 && partition.getPartitionEndWeek() == 0) {
    		if (partition.getPartitionBeginDate() != null && !partition.getPartitionBeginDate().isEmpty() && 
    				 partition.getPartitionEndDate() != null && !partition.getPartitionEndDate().isEmpty()) {
    			int result = partition.getPartitionBeginDate().compareTo(partition.getPartitionEndDate());
    			if (result < 0)
    				return true;
    			return false;
    		}
    		return false;
    	}
    	if ((partition.getPartitionBeginWeek() == 0 && partition.getPartitionEndWeek() != 0) || 
    			(partition.getPartitionBeginWeek() != 0 && partition.getPartitionEndWeek() == 0)) {
    		return false;
    	}
    	if (partition.getPartitionBeginDate() != null && partition.getPartitionEndDate() != null) {
	    	if ((partition.getPartitionBeginDate().isEmpty() && !partition.getPartitionEndDate().isEmpty()) || 
	    			(!partition.getPartitionBeginDate().isEmpty() && partition.getPartitionEndDate().isEmpty())) {
	    		return false;
	    	}
    	}
    	if (partition.getPartitionBeginDate() == null && partition.getPartitionEndDate() == null) {
    		if (partition.getPartitionBeginWeek() > partition.getPartitionEndWeek() || 
    				partition.getPartitionBeginWeek() < 1 || partition.getPartitionEndWeek() > 18)
    			return false;
    		return true;
    	}
    	return true;
	}
}
