package cims107.test;

import cims107.model.Building;

import java.sql.Date;

import cims107.action.PartitionCreateAction;
import cims107.dao.PartitionDao;
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


public class testPartitionCreateAction extends AbstractModelAndViewTests{
	public static PartitionService partition_service;
	public static BuildingService building_service;
	public static ClassroomService classroom_service;
	public PartitionCreateAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for PartitionCreateAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new PartitionCreateAction();
		    IMocksControl control = EasyMock.createControl();
		    partition_service = control.createMock(PartitionService.class);
		    building_service = control.createMock(BuildingService.class);
		    classroom_service = control.createMock(ClassroomService.class);
		    action.setPartitionService(partition_service);
		    action.buildingService = building_service;
		    action.classroomService = classroom_service;
		    
		    
		    action.buildingname = "TestingBuilding";
	    	action.compus = "TestingCompus";
	    	action.begindate = new Date(2014, 1, 1);
	    	action.beginlession = 2;
	    	action.beginweek = 2;
	    	action.enddate = new Date(2014, 1, 31);
	    	action.endlession = 5;
	    	action.endweek = 5;
	    	action.maxavailableseat = 100;
	    	action.minavailableseat = 50;
	    	action.pclassnum = 3;
	    	action.pdepartmentname = "TestingDepartment";
	    	action.pexamnum = 3;
	    	action.pisused = true;
	    	action.pterm = "first";
	    	action.pyear = "2014";
	    	action.serialnumber = "123";
	    	action.type = "TestingType";
	    	String[] whichday = {"1", "2"};
	    	action.setWhichday(whichday);

		    Building building = new Building();
		    building.setBuildingCompus("TestingCompus");
		    building.setBuildingDepartment("TestingDepartment");
		    building.setBuildingFloorNum(2);
		    building.setBuildingId(1);
		    building.setBuildingName("TestingBuilding");
		    building.setBuildingSimpleName("TB");
	    	
	    	Classroom classroom = new Classroom();
	    	classroom.setClsSerialNumber("123");
	    	
	    	EasyMock.expect(building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(building);
	    	EasyMock.expect(classroom_service.find(EasyMock.anyInt(), EasyMock.anyString())).andReturn(classroom);
	    	partition_service.add(EasyMock.anyObject());
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}