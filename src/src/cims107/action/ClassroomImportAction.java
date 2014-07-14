package cims107.action;

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

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomImportAction extends ActionSupport{
	private File excelFile;
    private String excelFileFileName;
    
    private ClassroomService classroomService;  
    
    public ClassroomImportAction()  
    {  
        System.out.println("initialize BuildingImportAction......");  
    }
    
    public void setBuildingService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
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
	        List<Classroom> classroomlst = new ArrayList<Classroom>();
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
	            
	            Classroom classroom = new Classroom();
	            Building building = new Building();
	    		BuildingService buildingService = new BuildingService();
	    		
	    		building = buildingService.find(ros.getCell(0).getStringCellValue(), ros.getCell(1).getStringCellValue());
	            
	            classroom.setClsSerialNumber(ros.getCell(0).getStringCellValue());
	            classroom.setClsFloor((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsType(ros.getCell(0).getStringCellValue());
	            classroom.setClsShape(ros.getCell(0).getStringCellValue());
	            classroom.setClsClassNum((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsExamNum((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsMaxRow((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsMaxCol((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsVCorridorLocate(ros.getCell(0).getStringCellValue());
	            classroom.setClsHCorridorLocate(ros.getCell(0).getStringCellValue());
	            classroom.setClsArea((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsLocation(ros.getCell(0).getStringCellValue());
	            classroom.setClsIsAmphi(ros.getCell(0).getBooleanCellValue());
	            classroom.setClsHasMicrophone(ros.getCell(0).getBooleanCellValue());
	            classroom.setClsIsUsed(ros.getCell(0).getBooleanCellValue());
	            classroom.setClsUsage(ros.getCell(0).getStringCellValue());
	            classroom.setClsSeatNum((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsAvailableSeatNum((int)ros.getCell(0).getNumericCellValue());
	            classroom.setClsBuildingId(building.getBuildingId());
	            
	            classroomlst.add(classroom);
	            //excelWorkSheet.getData().add(building);  
	        }
	        
	        //插入数据库
	        for (int i = 0; i < classroomlst.size(); i++) {
	        	Classroom c = classroomlst.get(i);
	        	classroomService.add(c);
	        }
        
    	}catch (FileNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        
        return SUCCESS;
    	
    }
}
