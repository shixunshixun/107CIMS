package cims107.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cims107.model.Department;
import cims107.model.Partition;
import cims107.service.DepartmentService;

public class DepartmentSearchAction extends ActionSupport implements ModelDriven<Department>{
	private DepartmentService departmentService;
	
	private Department department;
	private JSONArray result;
	
	public DepartmentSearchAction()  
    {  
        System.out.println("initialize BuildingSearchAction......");  
    }
	@Override
    public Department getModel() {
    	if(department == null) {
    		department = new Department();
    	}
    	return department;
    }
	
	public JSONArray getResult() {
		return result;
	}
	public void setResult(JSONArray result) {
		this.result = result;
	}
	public void setDepartmentService(DepartmentService departmentService)  
    {  
        this.departmentService = departmentService;  
    }
    
    public String execute() {
    	Department d = new Department();
    	JSONArray ja = new JSONArray();
    	
    	d = departmentService.find(department.getDepartmentId());
    	if (d != null) {
    		ja.add(JSONObject.fromObject(d));
    		result = ja;
    	}
    	else
    		result = null;
    	return SUCCESS;
    }
}
