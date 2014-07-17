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
    
    public void setClassroomService(ClassroomService classroomService)  
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
	            
	            classroom.setClsSerialNumber(ros.getCell(2).getStringCellValue());
	            classroom.setClsFloor((int)ros.getCell(3).getNumericCellValue());
	            classroom.setClsType(ros.getCell(4).getStringCellValue());
	            classroom.setClsShape(ros.getCell(5).getStringCellValue());
	            classroom.setClsClassNum((int)ros.getCell(6).getNumericCellValue());
	            classroom.setClsExamNum((int)ros.getCell(7).getNumericCellValue());
	            classroom.setClsMaxRow((int)ros.getCell(8).getNumericCellValue());
	            classroom.setClsMaxCol((int)ros.getCell(9).getNumericCellValue());
	            classroom.setClsVCorridorLocate(ros.getCell(10).getStringCellValue());
	            classroom.setClsHCorridorLocate(ros.getCell(11).getStringCellValue());
	            classroom.setClsArea((int)ros.getCell(12).getNumericCellValue());
	            classroom.setClsLocation(ros.getCell(13).getStringCellValue());
	            classroom.setClsIsAmphi((int)ros.getCell(14).getNumericCellValue());
	            classroom.setClsHasMicrophone((int)ros.getCell(15).getNumericCellValue());
	            classroom.setClsIsUsed((int)ros.getCell(16).getNumericCellValue());
	            classroom.setClsUsage(ros.getCell(17).getStringCellValue());
	            classroom.setClsSeatNum((int)ros.getCell(18).getNumericCellValue());
	            classroom.setClsAvailableSeatNum((int)ros.getCell(19).getNumericCellValue());
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
