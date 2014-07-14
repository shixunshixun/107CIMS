package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
import javax.servlet.http.HttpServletResponse;
  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class BuildingExportAction extends ActionSupport{
	
	public String[] buildingid;
	private HttpServletResponse response;
	
    private BuildingService buildingService;  
      
    public BuildingExportAction()  
    {  
        System.out.println("initialize BuildingExportAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
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
    	
		try {
			Workbook book = new HSSFWorkbook();
			Sheet sheet = book.createSheet("导出信息");
			Row row = sheet.createRow(0);
			
			row.createCell(0).setCellValue("教学楼名称");
			row.createCell(1).setCellValue("教学楼简称");
			row.createCell(2).setCellValue("所在校区");
			row.createCell(3).setCellValue("所属单位");
			row.createCell(4).setCellValue("楼层数");
			
			for(int i=0; i<=buildingid.length;i++){
            	row = sheet.createRow(i+1);

    			row.createCell(0).setCellValue(searchResult.get(i).getBuildingName());
    			row.createCell(1).setCellValue(searchResult.get(i).getBuildingSimpleName());
    			row.createCell(2).setCellValue(searchResult.get(i).getBuildingCompus());
    			row.createCell(3).setCellValue(searchResult.get(i).getBuildingDepartment());
    			row.createCell(4).setCellValue(searchResult.get(i).getBuildingFloorNum());
        	}
			
			book.write(response.getOutputStream());
			
			//直接返回Excel，暂时未测试
			response.setContentType("application/octet-stream;charset=iso-8859-1");  
            response.setHeader("Content-Disposition", "attachment;filename="  
                    +java.net.URLEncoder.encode("导出信息.xls", "UTF-8"));
            response.addHeader("Pargam", "no-cache");  
            response.addHeader("Cache-Control", "no-cache");  
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        return SUCCESS;
    }
	
}
