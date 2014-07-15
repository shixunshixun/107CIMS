package cims107.test;
/*
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cims107.service.UserService;
import cims107.model.User;

public class testUserService {
	
	public static UserService service;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Loading the configure file....");
		ApplicationContext context = new FileSystemXmlApplicationContext( new String[]
				{"src/ApplicationContext.xml"});
		System.out.println("Loaded succeed....");
		service = (UserService) context.getBean("userService");
		
	}
	
	@Test
	public void testisLogin1() {
		try {
			User user = new User();
			user.setUserId(null);
			user.setUserIsAdmin(false);
			user.setUserName("sysu1");
			user.setUserPassword("sysu1");
			
			System.out.println("The isLogin(user) is to be tested....");
			assertTrue(service.isLogin(user));  //The input is the user object
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testisLogin2() {
		try {
			
			System.out.println("The isLogin(name,password) is to be tested....");
			assertTrue(service.isLogin("sysu2", "sysu2") ); //The input is the combination of the user name and password
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	
	
}

*/
