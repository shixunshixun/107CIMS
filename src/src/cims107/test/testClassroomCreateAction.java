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
	
	//����������������������ȷ
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
		        
			System.out.println("ClassroomCreateAction:������");
			
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
		    
			System.out.println("ClassroomCreateAction:��building����Ϊ��");
			
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
		    
			System.out.println("ClassroomCreateAction:�������Ϊ0");
			
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
	
	//������λ������������ֳ���һλ��
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
		    
			System.out.println("ClassroomCreateAction:������λΪ0");
			
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
		    
			System.out.println("ClassroomCreateAction:������λ��С��0");
			
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
		    
			System.out.println("ClassroomCreateAction:��������Ϊ0");
			
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
		    
			System.out.println("ClassroomCreateAction:��������Ϊ����");
			
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
		    
			System.out.println("ClassroomCreateAction:������������λ����");
			
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
		    
			System.out.println("ClassroomCreateAction:�Ͽ�����Ϊ0");
			
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
		    
			System.out.println("ClassroomCreateAction:�Ͽ�����Ϊ-1");
			
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
		    
			System.out.println("ClassroomCreateAction:�Ͽ���������λ����");
			
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
		    
			System.out.println("ClassroomCreateAction:¥����Ϊ0");
			
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
		    
			System.out.println("ClassroomCreateAction:¥����Ϊ����");
			
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
		    
			System.out.println("ClassroomCreateAction:���ҹ��������λ�����1");
			
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
		    
			System.out.println("ClassroomCreateAction:���ҹ��������λ��Ϊ����");
			
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
		    
			System.out.println("ClassroomCreateAction:���ҹ��������λ��0");
			
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
		    
			System.out.println("ClassroomCreateAction:���ҹ��������λ������һ��������λ��");
			
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
		    
			System.out.println("ClassroomCreateAction:�������������ʽ������2,3,4");
			
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
		    
			System.out.println("ClassroomCreateAction:�������������ʽ������2,3;4");
			
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
		    
			System.out.println("ClassroomCreateAction:�������������ʽ������2,3;4,5;");
			
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
		    
			System.out.println("ClassroomCreateAction:�������������ʽ��ȷ����2,3;4,5");
			
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
		    
			System.out.println("ClassroomCreateAction:������������ �Կո�Ĵ�����2 ,3");
			
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
		    
			System.out.println("ClassroomCreateAction:�����������뵥����");
			
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
		    
			System.out.println("ClassroomCreateAction:�����������岻����");
			
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
		    
			System.out.println("ClassroomCreateAction:��������岻����");
			
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
		    
			System.out.println("ClassroomCreateAction:���������岻����");
			
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
		    
			System.out.println("ClassroomCreateAction:��ѧ¥���Ʋ�����");
			
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
		    
			System.out.println("ClassroomCreateAction:���ұ��Ϊ��");
			
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
		    
			System.out.println("ClassroomCreateAction:��������岻���룬�������Ҳ������");
			
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
		    
			System.out.println("ClassroomCreateAction:�������������,���Ƕ����˺�����");
			
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