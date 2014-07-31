package cims107.test;

import static org.junit.Assert.*;
import cims107.action.BuildingCreateAction;
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


public class testBuildingCreateAction extends  AbstractModelAndViewTests  {
	public static BuildingService service;
	public BuildingCreateAction action;
	public Building TBuilding;

	public testBuildingCreateAction() {
		TBuilding = new Building();
	}
	
	
	@Test
	public void testExecute1() {
		try{
			System.out.println("BuildingCreateAction:主场景");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
			//数据指定
			TBuilding.setBuildingCompus("TCompus");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(1);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("TBuilding");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(true);
	    	EasyMock.replay(service);
	    	assertEquals( "success" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute2() {
		try{
			System.out.println("BuildingCreateAction:教学楼楼层数小于等于0");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		    
		    //数据定义
			TBuilding.setBuildingCompus("TCompus");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(0);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("TBuilding");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	//EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(false);
	    	//EasyMock.replay(service);
	    	assertEquals( "hint" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute3() {
		try{
			System.out.println("BuildingCreateAction:当教学楼校区为空");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		    
		    //数据定义
			TBuilding.setBuildingCompus("");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(1);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("TBuilding");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	//EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(false);
	    	//EasyMock.replay(service);
	    	assertEquals( "hint" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute4() {
		try{
			System.out.println("BuildingCreateAction:教学楼名字为空");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		    
		    //数据定义
			TBuilding.setBuildingCompus("TCompus");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(1);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	//EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(false);
	    	//EasyMock.replay(service);
	    	assertEquals( "hint" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute5() {
		try{
			System.out.println("BuildingCreateAction:教学楼名字以及校区为空");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		    
		    //数据定义
			TBuilding.setBuildingCompus("");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(1);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	//EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(false);
	    	//EasyMock.replay(service);
	    	assertEquals( "hint" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute6() {
		try{
			System.out.println("BuildingCreateAction:输入正确但数据库无法插入数据");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
			//数据指定
			TBuilding.setBuildingCompus("TCompus");
			TBuilding.setBuildingDepartment("TDepartment");
			TBuilding.setBuildingFloorNum(1);
			TBuilding.setBuildingId(0);
			TBuilding.setBuildingName("TBuilding");
			TBuilding.setBuildingSimpleName("TB");
			
		    action = new BuildingCreateAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	action.setBuilding(TBuilding);
	    	
	    	EasyMock.expect(service.add(EasyMock.anyObject())).andReturn(false);
	    	EasyMock.replay(service);
	    	assertEquals( "error" , action.execute() );
	    	
	    	
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	
	
	
	


}