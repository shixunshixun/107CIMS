package cims107.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cims107.service.BuildingService;
import cims107.service.ClassroomService;
import cims107.model.Building;
import cims107.model.Classroom;
/*
public class testClassroomService {
	public static ClassroomService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Loading the configure file....");
		ApplicationContext context = new FileSystemXmlApplicationContext( new String[]
				{"src/ApplicationContext.xml","src/ApplicationContext-Building.xml"});
		System.out.println("Loaded succeed....");
		service = (ClassroomService) context.getBean("classroomService");
		
	}
	
	
	public testClassroomService(){

	}

/*	
	@Test
	public void testadd() {
		try{	
			System.out.println("The add method for BuildingService is to be tested....");
			assertTrue( service.add(building) );
			
		}catch( Exception e ){
			e.printStackTrace();
		}
			
	}
	

	@Test
	public void testfindbyName() {
		try {
			Building tempBuilding = new Building();
			
			System.out.println("The find by name method for BuildingService is to be tested....");
		    tempBuilding = service.find( building.getBuildingName(), building.getBuildingCompus() );
		    foundNum = tempBuilding.getBuildingId();
		    
		    building.setBuildingId(foundNum);
		    
		    assertEquals( building , tempBuilding );

		}catch( Exception e ){
			e.printStackTrace();
		}
	}


	@Test
	public void testfindbyId() {
		try {
			System.out.println("The find by buildingId method for BuildingService is to be tested....");
			assertEquals( building , service.find(foundNum));
			
		}catch( Exception e ){
			e.printStackTrace();
		}
	}

	@Test
	public void testupdate() {
		try {
			building.setBuildingFloorNum(5);
			
			System.out.println("The update method for BuildingService is to be tested....");
			assertTrue( service.update(foundNum, building));

		}catch( Exception e ){
			e.printStackTrace();
		}
	}


	@Test
	public void testdelete() {
		try {
			List<Integer> testList = new ArrayList<Integer>();
			testList.add(4);
			assertTrue( service.delete(testList) );

		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}

*/