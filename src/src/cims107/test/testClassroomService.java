package cims107.test;
/*
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cims107.service.ClassroomService;
import cims107.model.Classroom;

public class testClassroomService {
	public static ClassroomService service;
	public Classroom classroom;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Loading the configure file....");
		ApplicationContext context = new FileSystemXmlApplicationContext( new String[]
				{"src/ApplicationContext.xml","src/ApplicationContext-Building.xml"});   //The configuration to be added
		System.out.println("Loaded succeed....");
		service = (ClassroomService) context.getBean("classroomService");               //The Bean to be got
		
	}
	
	public testClassroomService() {
		classroom.setClsArea(50);
		classroom.setClsAvailableSeatNum(100);
		classroom.setClsBuildingId(1);
		classroom.setClsClassNum(1);
		classroom.setClsExamNum(80);
		classroom.setClsFloor(2);
		classroom.setClsHasMicrophone(true);
		classroom.setClsHCorridorLocate("West");
		classroom.setClsId(1);
		classroom.setClsIsAmphi(true);
		classroom.setClsIsUsed(true);
		classroom.setClsLocation("West");
		classroom.setClsMaxCol(30);
		classroom.setClsMaxRow(50);
		classroom.setClsSeatNum(100);
		classroom.setClsSerialNumber("123");
		classroom.setClsShape("testshape");
		classroom.setClsType("TestType");
		classroom.setClsUsage("TestUsage");
		classroom.setClsVCorridorLocate("West");
	}

	
	@Test
	public void testadd() {
		try{	
			System.out.println("The add method for ClassroomService is to be tested....");
			service.add(classroom);
			
		}catch( Exception e ){
			e.printStackTrace();
		}
			
	}
	

	@Test
	public void testfindbyKeyword() {
		try {
			System.out.println("The find by any keywords method for ClassService is to be tested....");
			
			List<Classroom> tempClassroom = new ArrayList<Classroom>();
			tempClassroom = service.find(null, 
					null, 
					null,
					null, 
					0,
					classroom.getClsSerialNumber(),
					0, 
					0,
					classroom.getClsArea(),
					0, 
					0, 
					classroom.getClsVCorridorLocate(), 
					classroom.getClsIsAmphi(), 
					classroom.getClsShape(), 
					classroom.getClsHasMicrophone(),
					classroom.getClsUsage(), 
					null);
			

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
/*
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

}*/

