package cims107.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cims107.action.PartitionUpdateAction;
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


public class testPartitionUpdateAction extends AbstractModelAndViewTests{
	public static PartitionService partition_service;
	public PartitionUpdateAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for PartitionUpdateAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new PartitionUpdateAction();
		    partition_service = EasyMock.createMock(PartitionService.class);
		    action.setPartitionService(partition_service);
		    
		    action.beginweek = 1;
		    action.endweek = 5;
		    action.pterm = "first";
		    action.pyear = "2014";
		    action.pdepartmentname = "TestingDepartment";
		    action.pid = 1;

	    	EasyMock.expect(partition_service.update(EasyMock.anyInt(), EasyMock.anyString(), EasyMock.anyString(), EasyMock.anyInt(), EasyMock.anyInt(), EasyMock.anyString())).andReturn(true);
	    	EasyMock.replay(partition_service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}