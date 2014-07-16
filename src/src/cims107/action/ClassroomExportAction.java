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
			Sheet sheet = book.createSheet("������Ϣ");
			Row row = sheet.createRow(0);
			
			row.createCell(0).setCellValue("��ѧ¥����");
			row.createCell(1).setCellValue("��ѧ¥����У��");
			row.createCell(2).setCellValue("���ұ��");
			row.createCell(3).setCellValue("����������λ����");
			row.createCell(4).setCellValue("����¥��");
			row.createCell(5).setCellValue("��������");			
			row.createCell(6).setCellValue("������״");
			row.createCell(7).setCellValue("�Ͽ�����");
			row.createCell(8).setCellValue("��������");
			row.createCell(9).setCellValue("�����λ��");			
			row.createCell(10).setCellValue("�������λ��");
			row.createCell(11).setCellValue("������λ��");
			row.createCell(12).setCellValue("������λ��");
			row.createCell(13).setCellValue("���");
			row.createCell(14).setCellValue("��λ");			
			row.createCell(15).setCellValue("�Ƿ���ݽ���");
			row.createCell(16).setCellValue("�Ƿ��л�Ͳ");
			row.createCell(17).setCellValue("���ñ�־");
			row.createCell(18).setCellValue("������;");
			row.createCell(19).setCellValue("����λ��");
			row.createCell(20).setCellValue("��Ч��λ��");
			
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
			
			//ֱ�ӷ���Excel����ʱδ����
			response.setContentType("application/octet-stream;charset=iso-8859-1");  
            response.setHeader("Content-Disposition", "attachment;filename="  
                    +java.net.URLEncoder.encode("������Ϣ.xls", "UTF-8"));
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
