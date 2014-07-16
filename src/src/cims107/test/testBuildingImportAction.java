package cims107.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import cims107.action.BuildingImportAction;
import cims107.dao.BuildingDao;
import cims107.model.*;
import cims107.service.*;

import org.apache.coyote.Request;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.easymock.EasyMock;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.AbstractModelAndViewTests;
import org.springframework.web.servlet.HandlerMapping;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;

/*
public class testBuildingImportAction extends AbstractModelAndViewTests{
	public static BuildingService service;
	public BuildingImportAction action;

	@Test
	public void testcreateWorkBook() {
		try{
			System.out.println("The createWorkBook method for BuildingImportAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
			action = new BuildingImportAction();
			service = EasyMock.createMock(BuildingService.class);
			action.setBuildingService(service);
			
			//≥ı ºªØInputStream
			String text = "temp.xls";
			InputStream is = new ByteArrayInputStream( text.getBytes());
			
			HSSFWorkbook workbook = new HSSFWorkbook(is);
			
			assertEquals( workbook , action.createWorkBook(is));
			
		}catch( Exception e ){
			e.printStackTrace();
		}
	
		
	}
	/*
	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for BuildingImportAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingImportAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);

		    String[] buildingid = {"2" , "1" };
		    action.setBuildingid(buildingid);
	    	
	    	EasyMock.expect(service.delete(EasyMock.anyObject())).andReturn(true);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}*/


