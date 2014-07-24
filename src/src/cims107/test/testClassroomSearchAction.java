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


public class testClassroomSearchAction extends AbstractModelAndViewTests{
	public static ClassroomService service;
	public ClassroomSearchAction action;
	public Classroom TClassroom;
	public Building TBuilding;

	public testClassroomSearchAction(){
	    
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
	
    //Ö÷³¡¾°
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
		    action.setClassroom(TClassroom);
		    
		    action.buildingname = "TesingBuilding";
		    action.compus = "TestingCompus";
		    action.departmentname = "TestingDepartment";
		    action.maxClassNum = 100;
		    action.maxExamNum = 100;
		    action.minClassNum = 50;
		    action.minExamNum = 50;

		    
			List<Classroom> classroomlst = new ArrayList<Classroom>();

			classroomlst.add(TClassroom);
		    
	    	EasyMock.expect(service.find(EasyMock.anyString(), 
	    			EasyMock.anyString(),
	    			EasyMock.anyString(),
	    			EasyMock.anyString(),
	    			EasyMock.anyInt(), 
	    			EasyMock.anyString(), 
	    			EasyMock.anyInt(), 
	    			EasyMock.anyInt(), 
	    			EasyMock.anyInt(),
	    			EasyMock.anyInt(),
	    			EasyMock.anyInt(), 
	    			EasyMock.anyString(), 
	    			EasyMock.anyInt(),
	    			EasyMock.anyString(), 
	    			EasyMock.anyInt(), 
	    			EasyMock.anyString(), 
	    			EasyMock.anyInt())).andReturn(classroomlst);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}

