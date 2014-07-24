package cims107.test;

import java.sql.Date;

import cims107.action.PartitionDeleteAction;
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
/*

public class testPartitionDeleteAction extends AbstractModelAndViewTests{
	public static PartitionService partition_service;

	public PartitionDeleteAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for PartitionDeleteAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new PartitionDeleteAction();
		    partition_service = EasyMock.createMock(PartitionService.class);
		    action.setPartitionService(partition_service);
		    
		    String[] partitionid = {"1","2"};
		    action.setPartitionid(partitionid);
	    	
	    	Classroom classroom = new Classroom();
	    	classroom.setClsSerialNumber("123");
	    	
	    	EasyMock.expect(partition_service.delete(EasyMock.anyObject())).andReturn(true);
	    	EasyMock.replay(partition_service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}*/