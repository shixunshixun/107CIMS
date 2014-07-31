package cims107.test;

import cims107.action.BuildingDeleteAction;
import cims107.dao.BuildingDao;
import cims107.model.*;
import cims107.service.*;

import org.apache.coyote.Request;
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

public class testBuildingDeleteAction extends AbstractModelAndViewTests{
	public static BuildingService service;
	public BuildingDeleteAction action;

	//Test the successful situation of the method execute
	@Test
	public void testExecute1() {
		try{
			System.out.println("BuildingDeleteAction:Ö÷³¡¾°");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingDeleteAction();
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
	
	
	//Test the error situation of the method Execute
	@Test
	public void testExecute2() {
		try{
			System.out.println("BuildingDeleteAction:É¾³ý·µ»ØÊ§°Ü");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingDeleteAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);

		    String[] buildingid = {};
		    action.setBuildingid(buildingid);
	    	
	    	EasyMock.expect(service.delete(EasyMock.anyObject())).andReturn(false);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}


}

