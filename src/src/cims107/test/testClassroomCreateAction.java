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
/*

public class testClassroomCreateAction extends AbstractModelAndViewTests{
	public static ClassroomService classroom_service;
	public static BuildingService building_service;
	public ClassroomCreateAction action;
	public Building TBuilding;
	public Classroom TClassroom;

	public testClassroomCreateAction() {
        TBuilding = new Building();
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    
	    TClassroom = new Classroom();
	    TClassroom.setBuilding(TBuilding);
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
	}
	
	//测试主场景，所有输入正确
	@Test
	public void testExecute1() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "ADDSUCCESS" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//当building返回为空
	@Test
	public void testExecute2() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(null);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//当走廊位置之间座位相间超过1
	@Test
	public void testExecute3() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
		    TClassroom.setClsHCorridorLocate("2,8");
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//当走廊位置中输入的数字超过一位数
	@Test
	public void testExecute4() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
		    TClassroom.setClsHCorridorLocate("10,11");
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "ADDSUCCESS" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//当输入走廊位置为（1,1）
	@Test
	public void testExecute5() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
		    TClassroom.setClsHCorridorLocate("1,1");
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//输入有效位置小于上课人数
	@Test
	public void testExecute6() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
		    TClassroom.setClsHCorridorLocate("2,1");
		    TClassroom.setClsAvailableSeatNum(45);
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//走廊定位中有位置超过行数
	@Test
	public void testExecute7() {
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
		    action.setClassroomService(classroom_service);
		    action.setBuildingService(building_service);
		    action.buildingname = TBuilding.getBuildingName();
		    action.setClassroom(TClassroom);
		    action.compus = TBuilding.getBuildingCompus();
		    
		    TClassroom.setClsHCorridorLocate("50,51");
		    TClassroom.setClsAvailableSeatNum(50);
		    
	    	EasyMock.expect( building_service.find(EasyMock.anyString(), EasyMock.anyString())).andReturn(TBuilding);
	    	classroom_service.add(EasyMock.anyObject() );
	    	EasyMock.expectLastCall();
	    	control.replay();
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	

}*/