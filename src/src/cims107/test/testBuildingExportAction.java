package cims107.test;
/*
import java.util.ArrayList;
import java.util.List;

import cims107.action.BuildingExportAction;
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


public class testBuildingExportAction extends AbstractModelAndViewTests{
	public static BuildingService service;
	public BuildingExportAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for BuildinExportAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new BuildingExportAction();
		    service = EasyMock.createMock(BuildingService.class);
		    action.setBuildingService(service);
	    	
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

}



/*****************************
initialize BuildingQueryAction......
The exectue method for BuildinExportAction is to be tested....
initialize BuildingExportAction......
java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
	at java.util.ArrayList.rangeCheck(Unknown Source)
	at java.util.ArrayList.get(Unknown Source)
	at cims107.action.BuildingExportAction.execute(BuildingExportAction.java:75)
	at cims107.test.testBuildingExportAction.testExectue(testBuildingExportAction.java:71)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at junit.framework.TestCase.runTest(TestCase.java:176)
	at junit.framework.TestCase.runBare(TestCase.java:141)
	at junit.framework.TestResult$1.protect(TestResult.java:122)
	at junit.framework.TestResult.runProtected(TestResult.java:142)
	at junit.framework.TestResult.run(TestResult.java:125)
	at junit.framework.TestCase.run(TestCase.java:129)
	at junit.framework.TestSuite.runTest(TestSuite.java:255)
	at junit.framework.TestSuite.run(TestSuite.java:250)
	at org.junit.internal.runners.JUnit38ClassRunner.run(JUnit38ClassRunner.java:84)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)


************************************/