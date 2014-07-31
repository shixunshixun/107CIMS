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
	public Building TBuilding;
	public Classroom TClassroom;

	public testClassroomCreateAction() {
        TBuilding = new Building();  
	    TClassroom = new Classroom();
	}
	
	//测试主场景，所有输入正确
	@Test
	public void testExecute1() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		        
			System.out.println("ClassroomCreateAction:主场景");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

	@Test
	public void testExecute2() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:当building返回为空");
			
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
	
	@Test
	public void testExecute3() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(0);                          //
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室面积为0");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	//当走廊位置中输入的数字超过一位数
	@Test
	public void testExecute4() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(0);     //0 is OK
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:可用座位为0");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute5() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(-1);     //-1 is wrong
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:可用座位数小于0");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute6() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(0);                  //0 is OK
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:考试人数为0");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute7() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(-1);                  //-1 is error
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:考试人数为负数");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute8() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(100);                
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:考试人数比座位数多");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute9() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(0);
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:上课人数为0");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute10() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(-1);
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:上课人数为-1");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute11() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(100);
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:上课人数比座位数多");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute12() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(0);
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:楼层数为0");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute13() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(-1);
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
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:楼层数为负数");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute14() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,6");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室过道标记座位差大于1");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute15() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("-1,-2");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室过道标记座位差为负数");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute16() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("10,10");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室过道标记座位差0");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute17() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("51,50");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室过道标记座位差其中一个大于座位数");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute18() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,3,4");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入格式错误，如2,3,4");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute19() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,3;4");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入格式错误，如2,3;4");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute20() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,3;4,5;");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入格式错误，如2,3;4,5;");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute21() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,3;4,5;");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入格式正确，如2,3;4,5");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	
	@Test
	public void testExecute22() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2 ,3");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入 对空格的处理，如2 ,3");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute23() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("2,3");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:过道定义输入单数字");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute24() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate(null);
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate(null);
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:横竖过道定义不输入");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute25() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate(null);
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("3,4");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:横过道定义不输入");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute26() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("3,4");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:竖过道定义不输入");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	@Test
	public void testExecute27() {
		try{
		    TBuilding.setBuildingCompus("");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("3,4");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("3,4");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:教学楼名称不输入");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute28() {
		try{
		    TBuilding.setBuildingCompus("TBuilding");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("3,4");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(50);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("3,4");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:课室编号为空");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute29() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate(null);
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(0);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("3,4");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:横过道定义不输入，最大行数也不输入");
			
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
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute30() {
		try{
		    TBuilding.setBuildingCompus("TestingCompus");
		    TBuilding.setBuildingDepartment("TestingDepartment");
		    TBuilding.setBuildingFloorNum(2);
		    TBuilding.setBuildingId(1);
		    TBuilding.setBuildingName("TestingBuilding");
		    TBuilding.setBuildingSimpleName("TB");
		    //buildingService.find return an unique building
		    TClassroom.setClsArea(50);                          
		    TClassroom.setClsAvailableSeatNum(50);     
		    TClassroom.setClsExamNum(50);                
		    TClassroom.setClsClassNum(50);
		    TClassroom.setClsFloor(1);
		    TClassroom.setClsHasMicrophone(1);
		    TClassroom.setClsHCorridorLocate("2,3");
		    TClassroom.setClsId(1);
		    TClassroom.setClsIsAmphi(1);
		    TClassroom.setClsIsUsed(1);
		    TClassroom.setClsLocation("12");
		    TClassroom.setClsMaxCol(50);
		    TClassroom.setClsMaxRow(0);
		    TClassroom.setClsSeatNum(50);
		    TClassroom.setClsSerialNumber("123");
		    TClassroom.setClsShape("TShape");
		    TClassroom.setClsType("TType");
		    TClassroom.setClsUsage("TUsage");
		    TClassroom.setClsVCorridorLocate("3,4");
		    TClassroom.setPartitions(null);
		    
			System.out.println("ClassroomCreateAction:最大行数不输入,但是定义了横走廊");
			
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
	    	
	    	assertEquals( "hint" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	

}