package cims107.test;

import java.util.ArrayList;
import java.util.List;

import cims107.action.ClassroomExportAction;
import cims107.dao.ClassroomDao;
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

/*
public class testClassroomExportAction extends AbstractModelAndViewTests{
	public static ClassroomService classroom_service;
	public static BuildingService building_service;
	public ClassroomExportAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for BuildinExportAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new ClassroomExportAction();
		    service = EasyMock.createMock(ClassroomService.class);
		    action.setClassService(service);
	    	
		    String[] buildingid = {"2" , "1" };
		    action.setBuildingid(buildingid);
	    	List<Building> searchResult = new ArrayList<Building>();
	    	
	    	Building building1 = new Building();
	    	building1.setBuildingCompus("TestingBuildingCompus");
	    	building1.setBuildingDepartment("TestingBuildingDepartment");
	    	building1.setBuildingFloorNum(2);
	    	building1.setBuildingId(1);
	    	building1.setBuildingName("TestingBuilding1");
	    	building1.setBuildingSimpleName("TB1");
	    	
	    	Building building2 = new Building();
	    	building2.setBuildingCompus("TestingBuildingCompus");
	    	building2.setBuildingDepartment("TestingBuildingDepartment");
	    	building2.setBuildingFloorNum(2);
	    	building2.setBuildingId(2);
	    	building2.setBuildingName("TestingBuilding2");
	    	building2.setBuildingSimpleName("TB2");
	    	
	    	searchResult.add(building2);
	    	searchResult.add(building1);
		    
	    	EasyMock.expect(service.find(EasyMock.anyObject())).andReturn(searchResult);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}*/

