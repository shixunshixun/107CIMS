package cims107.test;
/*
import java.util.ArrayList;
import java.util.List;

import cims107.action.BuildingSearchAction;
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


public class testBuildingSearchAction extends AbstractModelAndViewTests{
	public static BuildingService service;
	public BuildingSearchAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for BuildingSearchAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingSearchAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	List<Building> searchResult = new ArrayList<Building>();
	    	
	    	Building building1 = new Building();
	    	building1.setBuildingCompus("TestingBuildingCompus");
	    	building1.setBuildingDepartment("TestingBuildingDepartment");
	    	building1.setBuildingFloorNum(2);
	    	building1.setBuildingId(1);
	    	building1.setBuildingName("TestingBuilding1");
	    	building1.setBuildingSimpleName("TB1");
	    	
	    	searchResult.add(building1);
		    
	    	EasyMock.expect(service.find(building1.getBuildingName(),
	    			building1.getBuildingDepartment(),
	    			building1.getBuildingSimpleName(),
	    			building1.getBuildingCompus())).andReturn(searchResult);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}


/*id一定是要数字的字符串，开发的程序在容错性上存在漏洞 */