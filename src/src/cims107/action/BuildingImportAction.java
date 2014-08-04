package cims107.action;

import cims107.model.Building;
import cims107.service.BuildingService;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
  

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  


import cims107.model.ExcelWorkSheet;  
import cims107.model.Building;   

import com.opensymphony.xwork2.ActionSupport;

public class BuildingImportAction extends ActionSupport{

	/* 估计暂时用不到
	 * public String buildingname;  
	public String departmentname;  
	public String simplename;
	public String compus;
	public int floor;*/
	
	private File excelFile;
	private JSONObject result;
    private String excelFileFileName;
    
    //暂且删掉这个变量，因为似乎没有多大作用
    //private ExcelWorkSheet<Building> excelWorkSheet;
    
    private BuildingService buildingService;  
      
    public BuildingImportAction()  
    {  
        System.out.println("initialize BuildingImportAction......");  
    }
    
    public void setBuildingService(BuildingService buildingService)  
    {  
        this.buildingService = buildingService;  
    }  
     
    public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public File getExcelFile() {  
        return excelFile;  
    }  
  
    public void setExcelFile(File excelFile) {  
        this.excelFile = excelFile;  
    }  
  
    public String getExcelFileFileName() {  
        return excelFileFileName;  
    }  
  
    public void setExcelFileFileName(String excelFileFileName) {  
        this.excelFileFileName = excelFileFileName;  
    }    
      
    //判断文件类型  
    public Workbook createWorkBook(InputStream is) throws IOException{  
        if(excelFileFileName.toLowerCase().endsWith("xls")){  
            return new HSSFWorkbook(is);  
        }  
        if(excelFileFileName.toLowerCase().endsWith("xlsx")){  
            return new XSSFWorkbook(is);  
        }  
        return null;  
    }
      
    public String execute() throws FileNotFoundException,IOException 
    {
    	try {
	    	Workbook book = createWorkBook(new FileInputStream(excelFileFileName));  
	        //book.getNumberOfSheets();  判断Excel文件有多少个sheet  
	        
	    	List<Building> buildinglst = LoadDataFromExcel(book);
	        //插入数据库
	        for (int i = 0; i < buildinglst.size(); i++) {
	        	Building b = buildinglst.get(i);
	        	buildingService.add(b);
	        }
	        result = JSONObject.fromObject("{\"success\":1}");
        
    	}catch (FileNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	result = JSONObject.fromObject("{\"error\":\"教学楼导入失败\"}");
        	return SUCCESS;
        }
        
        return SUCCESS;
    	
    }
    
    public List<Building> LoadDataFromExcel(Workbook book) {
    	List<Building> blst = new ArrayList<Building>();
    	Sheet sheet = book.getSheetAt(0);
    	Row firstRow = sheet.getRow(0);  
    	Iterator<Cell> iterator = firstRow.iterator(); 
    	
    	List<String> cellNames = new ArrayList<String>();  
        while (iterator.hasNext()) {  
            cellNames.add(iterator.next().getStringCellValue());  
        }
    	
    	for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            Row ros = sheet.getRow(i);  
            Building building = new Building();  
            building.setBuildingName(ros.getCell(0).getStringCellValue());  
            building.setBuildingDepartment(ros.getCell(1).getStringCellValue());  
            building.setBuildingSimpleName(ros.getCell(2).getStringCellValue());  
            building.setBuildingCompus(ros.getCell(3).getStringCellValue());  
            building.setBuildingFloorNum((int)ros.getCell(4).getNumericCellValue());
            blst.add(building); 
        }
    	
    	return blst;
    }
    
}
