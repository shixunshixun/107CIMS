package cims107.test;
/*
import cims107.action.*;
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


public class testLoginAction extends AbstractModelAndViewTests{
	public static UserService service;
	public LoginAction action;

	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for LoginAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    LoginAction action = new LoginAction();
		    service = EasyMock.createMock(UserService.class);
		    action.setUserService(service);

		    action.setUserName("sysu1");
	    	action.setPassword("sysu1");
	    	
	    	EasyMock.expect(service.isLogin(action.getUserName(), action.getPassword())).andReturn(true);
	    	EasyMock.replay(service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}
	
	@Test
	public void testValidate(){
		try {
			System.out.println("The Validate method for LoginAction is to be tested....");

			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    LoginAction action = new LoginAction();
		    service = EasyMock.createMock(UserService.class);
		    action.setUserService(service);
		    
			action.setUserName(null);
			action.setPassword(null);		
			
			action.validate();
			
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
}*/