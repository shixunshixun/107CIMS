package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingDeleteAction extends ActionSupport{
	
	public String[] buildingid;
	private String result;  
	
    private BuildingService buildingService;  
      
    public BuildingDeleteAction()  
    {  
        System.out.println("initialize BuildingDeletesAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }      
    
    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String[] getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String[] buildingid) {
		this.buildingid = buildingid;
	}

	public String execute()  
    {  
		//JSONArray ja = new JSONArray();
    	List<Integer> buildingidlst = new ArrayList<Integer>();
    	
    	//auto convert?
    	for(int i=0; i<buildingid.length;i++){
    		buildingidlst.add(new Integer (buildingid[i]));
    	}
    	
    	try {
	    	if(buildingService.delete(buildingidlst)){
	    		//ja.add(JSONObject.fromObject(1));
	    		result = JSONObject.fromObject("{\"success\":1}").toString();
	    		return SUCCESS;
	    	}
	    	else {
	    		//super.addActionError("delete failed");
	    		return ERROR;
	    	}
    	}
    	catch(Exception e) {
    		result = JSONObject.fromObject("{\"error\":\"É¾³ýÊ§°Ü\"}").toString();
    		return SUCCESS;
    	}
    }
}
