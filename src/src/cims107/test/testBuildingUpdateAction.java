package cims107.test;

import java.util.ArrayList;
import java.util.List;

import cims107.action.BuildingUpdateAction;
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


public class testBuildingUpdateAction extends AbstractModelAndViewTests{
	public static BuildingService service;
	public BuildingUpdateAction action;
	public Building TBuilding;

	
	public testBuildingUpdateAction(){
		TBuilding = new Building();
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
	}
	
	@Test
	public void testExecute1() {
		try{
			System.out.println("The execute method for BuildingUpdateAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingUpdateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
		    action.setBuilding(TBuilding);
	    	
	    	EasyMock.expect(service.update(EasyMock.anyObject())).andReturn(true);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

	@Test
	public void testExecute2() {
		try{
			System.out.println("The execute method for BuildingUpdateAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingUpdateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	
	    	EasyMock.expect(service.update(EasyMock.anyObject())).andReturn(false);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
}

