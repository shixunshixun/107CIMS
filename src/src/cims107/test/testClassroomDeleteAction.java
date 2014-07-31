package cims107.test;

import java.util.ArrayList;
import java.util.List;

import cims107.action.ClassroomDeleteAction;
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


public class testClassroomDeleteAction extends AbstractModelAndViewTests{
	public static ClassroomService service;
	public ClassroomDeleteAction action;

	
	@Test
	public void testExecute1() {
		try{
			System.out.println(" ClassroomDeleteAction:Ö÷³¡¾°");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new ClassroomDeleteAction();
		    service = EasyMock.createMock(ClassroomService.class);
		    action.setClassroomService(service);
		    
		    String[] clsid = {"1","2"};
		    action.setClsid(clsid);

		    
	    	EasyMock.expect(service.delete(EasyMock.anyObject())).andReturn(true);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testExecute2() {
		try{
			System.out.println(" ClassroomDeleteAction:É¾³ý²Ù×÷·µ»Ø´íÎó");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new ClassroomDeleteAction();
		    service = EasyMock.createMock(ClassroomService.class);
		    action.setClassroomService(service);
		    
		    String[] clsid = {"1","2"};
		    action.setClsid(clsid);

		    
	    	EasyMock.expect(service.delete(EasyMock.anyObject())).andReturn(false);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "error" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}

