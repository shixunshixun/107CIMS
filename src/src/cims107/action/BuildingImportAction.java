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
  
    /*public ExcelWorkSheet<Building> getExcelWorkSheet() {  
        return excelWorkSheet;  
    }  
  
    public void setExcelWorkSheet(ExcelWorkSheet<Building> excelWorkSheet) {  
        this.excelWorkSheet = excelWorkSheet;  
    }  */
  
      
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
	    	Workbook book = createWorkBook(new FileInputStream(excelFile));  
	        //book.getNumberOfSheets();  判断Excel文件有多少个sheet  
	        Sheet sheet =  book.getSheetAt(0);  
	        List<Building> buildinglst = new ArrayList<Building>();
	        //excelWorkSheet = new ExcelWorkSheet<Building>();  
	        //保存工作单名称  
	        Row firstRow = sheet.getRow(0);  
	        Iterator<Cell> iterator = firstRow.iterator();  
	          
	        //保存列名  
	        List<String> cellNames = new ArrayList<String>();  
	        while (iterator.hasNext()) {  
	            cellNames.add(iterator.next().getStringCellValue());  
	        }  
	        //excelWorkSheet.setColumns(cellNames);  
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
	            Row ros = sheet.getRow(i);  
	            Building building = new Building();  
	            building.setBuildingName(ros.getCell(0).getStringCellValue());  
	            building.setBuldingDepartment(ros.getCell(1).getStringCellValue());  
	            building.setBuildingSimpleName(ros.getCell(2).getStringCellValue());  
	            building.setBuildingCompus(ros.getCell(3).getStringCellValue());  
	            building.setBuildingFloorNum((int)ros.getCell(4).getNumericCellValue());
	            buildinglst.add(building);
	            //excelWorkSheet.getData().add(building);  
	        }
	        
	        //插入数据库
	        for (int i = 0; i < buildinglst.size(); i++) {
	        	Building b = buildinglst.get(i);
	        	buildingService.add(b);
	        }
        
    	}catch (FileNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        
        return SUCCESS;
    	
    }
    
}
