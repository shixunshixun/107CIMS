package cims107.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.service.BuildingService;
import cims107.service.ClassroomService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassroomExportAction extends ActionSupport{
	public String[] clsid;
	private HttpServletResponse response;
	
    private ClassroomService classroomService;  
      
    public ClassroomExportAction()  
    {  
        System.out.println("initialize BuildingExportAction......");  
    }
    
    public void setClassService(ClassroomService classroomService)  
    {  
        this.classroomService = classroomService;  
    }

	public String[] getClsid() {
		return clsid;
	}

	public void setClsid(String[] clsid) {
		this.clsid = clsid;
	}
	
	public String execute() {
		List<Integer> clsidlst = new ArrayList<Integer>();
    	List<Classroom> searchResult = new ArrayList<Classroom>();
    	BuildingService buildingService = new BuildingService();
    	
    	for(int i=0; i<clsid.length;i++){
    		clsidlst.add(new Integer (clsid[i]));
    	}
    	
    	searchResult = classroomService.find(clsidlst);
    	//buildingService.find(searchResult.get(0).getClsBuildingId());
    	
		try {
			Workbook book = new HSSFWorkbook();
			Sheet sheet = book.createSheet("导出信息");
			Row row = sheet.createRow(0);
			
			row.createCell(0).setCellValue("教学楼名称");
			row.createCell(1).setCellValue("教学楼所在校区");
			row.createCell(2).setCellValue("教室编号");
			row.createCell(3).setCellValue("教室所属单位名称");
			row.createCell(4).setCellValue("所在楼层");
			row.createCell(5).setCellValue("教室类型");			
			row.createCell(6).setCellValue("教室形状");
			row.createCell(7).setCellValue("上课人数");
			row.createCell(8).setCellValue("考试人数");
			row.createCell(9).setCellValue("最长行座位数");			
			row.createCell(10).setCellValue("最宽列座位数");
			row.createCell(11).setCellValue("竖走廊位置");
			row.createCell(12).setCellValue("横走廊位置");
			row.createCell(13).setCellValue("面积");
			row.createCell(14).setCellValue("方位");			
			row.createCell(15).setCellValue("是否阶梯教室");
			row.createCell(16).setCellValue("是否有话筒");
			row.createCell(17).setCellValue("启用标志");
			row.createCell(18).setCellValue("教室用途");
			row.createCell(19).setCellValue("总座位数");
			row.createCell(20).setCellValue("有效座位数");
			
			for(int i=0; i<clsid.length;i++){
				Building building = new Building();
            	row = sheet.createRow(i+1);

            	building = buildingService.find(searchResult.get(i).getClsBuildingId());
            	
    			row.createCell(0).setCellValue(building.getBuildingName());
    			row.createCell(1).setCellValue(building.getBuildingCompus());
    			row.createCell(2).setCellValue(searchResult.get(i).getClsSerialNumber());
    			row.createCell(3).setCellValue(building.getBuildingDepartment());
    			row.createCell(4).setCellValue(searchResult.get(i).getClsFloor());
    			row.createCell(5).setCellValue(searchResult.get(i).getClsType());			
    			row.createCell(6).setCellValue(searchResult.get(i).getClsShape());
    			row.createCell(7).setCellValue(searchResult.get(i).getClsClassNum());
    			row.createCell(8).setCellValue(searchResult.get(i).getClsExamNum());
    			row.createCell(9).setCellValue(searchResult.get(i).getClsMaxRow());			
    			row.createCell(10).setCellValue(searchResult.get(i).getClsMaxCol());
    			row.createCell(11).setCellValue(searchResult.get(i).getClsVCorridorLocate());
    			row.createCell(12).setCellValue(searchResult.get(i).getClsHCorridorLocate());
    			row.createCell(13).setCellValue(searchResult.get(i).getClsArea());
    			row.createCell(14).setCellValue(searchResult.get(i).getClsLocation());			
    			row.createCell(15).setCellValue(searchResult.get(i).getClsIsAmphi());
    			row.createCell(16).setCellValue(searchResult.get(i).getClsHasMicrophone());
    			row.createCell(17).setCellValue(searchResult.get(i).getClsIsUsed());
    			row.createCell(18).setCellValue(searchResult.get(i).getClsUsage());
    			row.createCell(19).setCellValue(searchResult.get(i).getClsSeatNum());
    			row.createCell(20).setCellValue(searchResult.get(i).getClsAvailableSeatNum());
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
