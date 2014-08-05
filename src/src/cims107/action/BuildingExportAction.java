package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

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

public class BuildingExportAction extends ActionSupport implements ServletResponseAware{
	
	public String[] buildingid;
	private HttpServletResponse response;
	private String filename;
	private String format = "xls";
	
    private BuildingService buildingService;  
      
    public BuildingExportAction()  
    {  
        System.out.println("initialize BuildingExportAction......");  
    }
    public void setServletResponse(HttpServletResponse response) {  
        this.response = response;  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
   
    public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
		this.filename = "��������.xls";
	}
	public String[] getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String[] buildingid) {
		this.buildingid = buildingid;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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
	    	response.setContentType("application/octet-stream;charset=iso-8859-1");  
	        response.setHeader("Content-Disposition", "attachment;filename="  
	                +java.net.URLEncoder.encode("��ѧ¥����.xls", "UTF-8"));
	        response.addHeader("Pargam", "no-cache");  
	        response.addHeader("Cache-Control", "no-cache"); 
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        
		try {
			Workbook book = new HSSFWorkbook();
			Sheet sheet = book.createSheet("������Ϣ");
			Row row = sheet.createRow(0);
			
			row.createCell(0).setCellValue("��ѧ¥����");
			row.createCell(1).setCellValue("��ѧ¥���");
			row.createCell(2).setCellValue("����У��");
			row.createCell(3).setCellValue("������λ");
			row.createCell(4).setCellValue("¥����");
			
			for(int i=0; i<buildingid.length;i++){
            	row = sheet.createRow(i+1);

    			row.createCell(0).setCellValue(searchResult.get(i).getBuildingName());
    			row.createCell(1).setCellValue(searchResult.get(i).getBuildingSimpleName());
    			row.createCell(2).setCellValue(searchResult.get(i).getBuildingCompus());
    			row.createCell(3).setCellValue(searchResult.get(i).getBuildingDepartment());
    			row.createCell(4).setCellValue(searchResult.get(i).getBuildingFloorNum());
        	}
			try {
				book.write(response.getOutputStream());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			//ֱ�ӷ���Excel����ʱδ����
			 
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        return SUCCESS;
    }
	
}
