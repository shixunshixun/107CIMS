package cims107.test;

import java.util.ArrayList;
import java.util.List;

import cims107.action.ClassroomSearchAction;
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
public class testClassroomSearchAction extends AbstractModelAndViewTests{
	public static ClassroomService service;
	public ClassroomSearchAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for ClassroomSearchAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new ClassroomSearchAction();
		    service = EasyMock.createMock(ClassroomService.class);
		    action.setClassroomService(service);
		    
		    action.area = 50;
		    action.buildingname = "TesingBuilding";
		    action.compus = "TestingCompus";
		    action.departmentname = "TestingDepartment";
		    action.floor = 6;
		    action.hasmicrophone = true;
		    action.isamphi = true;
		    action.isused = true;
		    action.location = "West";
		    action.maxClassNum = 100;
		    action.maxExamNum = 100;
		    action.minClassNum = 50;
		    action.minExamNum = 50;
		    action.serialnumber = "123";
		    action.shape = "TestingShape";
		    action.type = "TestingType";
		    action.usage = "TestingUsage";
		    
		    
			List<Classroom> classroomlst = new ArrayList<Classroom>();
			
			Classroom classroom = new Classroom();
			classroom.setClsArea(50);
			classroom.setClsBuildingId(1);
			classroom.setClsFloor(6);
			classroom.setClsHasMicrophone(true);
			classroom.setClsHasMicrophone(true);
			classroom.setClsIsAmphi(true);
			classroom.setClsIsUsed(true);
			classroom.setClsLocation("West");
			classroom.setClsClassNum(100);
			classroom.setClsExamNum(50);
			classroom.setClsSerialNumber("123");
			classroom.setClsShape("TestingShape");
			classroom.setClsType("TestingType");
			classroom.setClsUsage("TestingUsage");

			classroomlst.add(classroom);
		    
	    	EasyMock.expect(service.find(EasyMock.anyString(), 
	    			EasyMock.anyString(), EasyMock.anyString(), EasyMock.anyString(), 
					EasyMock.anyInt(), EasyMock.anyString(), EasyMock.anyInt(),
					EasyMock.anyInt(), EasyMock.anyInt(), EasyMock.anyInt(),
					EasyMock.anyInt(), EasyMock.anyString(), EasyMock.anyBoolean(),
					EasyMock.anyString(), EasyMock.anyBoolean(), EasyMock.anyString(),
					EasyMock.anyBoolean())).andReturn(classroomlst);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}*/

