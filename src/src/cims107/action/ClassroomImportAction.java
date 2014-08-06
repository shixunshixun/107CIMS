package cims107.action;

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

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;
import cims107.service.SeatManageService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomImportAction extends ActionSupport{
	private File excelFile;
    private String excelFileFileName;
    private JSONObject result;
    
    private ClassroomService classroomService; 
    private SeatManageService seatmanageService;
    public SeatManageService getSeatmanageService() {
		return seatmanageService;
	}

	public void setSeatmanageService(SeatManageService seatmanageService) {
		this.seatmanageService = seatmanageService;
	}

	BuildingService buildingService;
    
    public BuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public ClassroomImportAction()  
    {  
        System.out.println("initialize BuildingImportAction......");  
    }
    
    public void setClassroomService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
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
    		if (excelFile == null) {
    			result = JSONObject.fromObject("{\"error\":\"清选择文件\"}");
            	return ERROR;
    		}
    		
		    Workbook book = createWorkBook(new FileInputStream(excelFile));  
		    if (isValidate(book)) {
		    	List<Classroom> classroomlst = LoadDataFromExcel(book);
		        //插入数据库
		        for (int i = 0; i < classroomlst.size(); i++) {
		        	Classroom c = classroomlst.get(i);
		        	classroomService.add(c);
		        	seatmanageService.add(c, c.getClsMaxRow(), c.getClsMaxCol());
		        }
		        result = JSONObject.fromObject("{\"success\":\"导入成功\"}");
    		}
    		else
    			result = JSONObject.fromObject("{\"error\":\"教室导入失败\"}"); 
    		return SUCCESS;
        
    	}catch (FileNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	result = JSONObject.fromObject("{\"error\":\"教室导入失败,信息不能重复\"}");
        	return SUCCESS;
        } catch (Exception e) {
        	result = JSONObject.fromObject("{\"error\":\"导入失败\"}");
        	return SUCCESS;
        }
    }
    
    public List<Classroom> LoadDataFromExcel(Workbook book) {
    	Sheet sheet =  book.getSheetAt(0);  
        List<Classroom> classroomlst = new ArrayList<Classroom>();
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
            classroom.setBuilding(building);
            
            classroomlst.add(classroom);
        }
        return classroomlst;
    }
    
    public Boolean isValidate(Workbook book) {
    	List<Classroom> clslst = LoadDataFromExcel(book);
    	
    	for (int i = 0; i < clslst.size(); i ++) {
    		for (int j = i+1; j < clslst.size(); j ++) {
    			if (clslst.get(i).getBuilding().getBuildingCompus() == clslst.get(j).getBuilding().getBuildingCompus() && 
    					clslst.get(i).getBuilding().getBuildingName() == clslst.get(j).getBuilding().getBuildingName() && 
    					i != j)
    				return false;
    		}
    	}
    	return true;
    }
}
