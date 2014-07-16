package cims107.test;

import cims107.action.ClassroomCreateAction;
import cims107.dao.BuildingDao;
import cims107.model.*;
import cims107.service.*;

import org.apache.coyote.Request;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
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


public class testClassroomCreateAction extends AbstractModelAndViewTests{
	public static ClassroomService classroom_service;
	public static BuildingService building_service;
	public ClassroomCreateAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for ClassroomCreateAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new ClassroomCreateAction();
		    IMocksControl control = EasyMock.createControl();
		    classroom_service = control.createMock(ClassroomService.class);
		    building_service = control.createMock(BuildingService.class);
		    action.setClassroomService( classroom_service);
		    action.buildingService = building_service;
		    
		    action.area = 50;
		    action.availableseatnum = 50;
		    action.buildingname = "TestingBuilding";
		    action.classnum = 1;
		    action.compus = "TestingCompus";
		    action.examnum = 50;
		    action.floor = 5;
		    action.hasmicrophone = true;
		    action.hcorridorlocate = "none";
		    action.isamphi = true;
		    action.isused = true;
		    action.location = "West";
		    action.maxcol = 50;
		    action.maxrow = 5;
		    action.seatnum = 50;
		    action.serialnumber = "123";
		    action.shape = "TestShape";
		    action.type = "TestType";
		    action.usage = "TestUsage";
		    action.vcorridorlocate = "Testv";
		    
		    Building building = new Building();
		    building.setBuildingCompus("TestingCompus");
		    building.setBuildingDepartment("TestingDepartment");
		    building.setBuildingFloorNum(2);
		    building.setBuildingId(1);
		    building.setBuildingName("TestingBuilding");
		    building.setBuildingSimpleName("TB");
		    
		    
	    	EasyMock.expect( building_service.find("TestingBuilding", "TestingCompus")).andReturn(building);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "addsuccess" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}