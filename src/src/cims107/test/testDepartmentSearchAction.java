package cims107.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cims107.action.DepartmentSearchAction;
import cims107.dao.DepartmentDao;
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


public class testDepartmentSearchAction extends AbstractModelAndViewTests{
	public static DepartmentService service;
	public DepartmentSearchAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for DepartmentSearchAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new DepartmentSearchAction();
		    service = EasyMock.createMock(DepartmentService.class);
		    action.setDepartmentService(service);
		    
		    action.departmentid = "1";
		    
		    Department department = new Department();
		    department.setDepartmentId("1");
		    department.setDepartmentName("TestingDepartment");

	    	EasyMock.expect(service.find(EasyMock.anyString())).andReturn(department);
	    	EasyMock.replay(service);
	    
	    	assertEquals( "success" , action.execute() );
	    	assertEquals( "TestingDepartment" , action.departmentname );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}