package cims107.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Building;
import cims107.service.BuildingService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class BuildingExportAction extends ActionSupport{
	
	public String[] buildingid;
	InputStream is;
	
    private BuildingService buildingService;  
      
    public BuildingExportAction()  
    {  
        System.out.println("initialize BuildingExportAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
   
    public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public String[] getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String[] buildingid) {
		this.buildingid = buildingid;
	}
	
	public String execute()  
    {  
		List<Integer> buildingidlst = new ArrayList<Integer>();
    	List<Building> searchResult = new ArrayList<Building>();
    	
    	for(int i=0; i<buildingid.length;i++){
    		buildingidlst.add(new Integer (buildingid[i]));
    	}
    	searchResult = buildingService.find(buildingidlst);
    	
		Label label;
        WritableWorkbook workbook;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            
            //标题
            sheet.addCell(new Label(0, 0, "教学楼名称"));
            sheet.addCell(new Label(0, 1, "教学楼简称"));
            sheet.addCell(new Label(0, 2, "所在校区"));
            sheet.addCell(new Label(0, 3, "所属单位"));
            sheet.addCell(new Label(0, 4, "楼层数"));
            
            //数据
            for(int i=1; i<=buildingid.length;i++){
            	sheet.addCell(new Label(i, 0, "教学楼名称"));
            	sheet.addCell(new Label(i, 1, "教学楼简称"));
            	sheet.addCell(new Label(i, 2, "所在校区"));
            	sheet.addCell(new Label(i, 3, "所属单位"));
            	sheet.addCell(new Label(i, 4, "楼层数"));
        	}
            
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        is = new ByteArrayInputStream(os.toByteArray());
    	return "excel";
    }
	
}
