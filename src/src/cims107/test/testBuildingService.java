/**
 * �����ʹ�÷���Ϊ��
 * 1��ע�͵������캯��,setUpBeforeClass�Լ�testadd�����෽����Ȼ����в��ԣ�
 * 2.ע�͵�testadd,ȥ������testfindbyName��ע��,���в��ԣ����õ���foundNum�����ڹ��캯������foundNum�����޸ģ�
 * 3��ע�͵�testfindbyName,ȥ��testfindbyId��ע�ͣ����ԣ�
 * 4��ע�͵�testfindbyId,ȥtestupdateע��,���ԣ�
 * 5�����ȥtestdeleteע�ͣ����ԡ�
 */

package cims107.test;
/*
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cims107.service.BuildingService;
import cims107.service.UserService;
import cims107.model.Building;
import cims107.model.User;


public class testBuildingService {
	public static BuildingService service;
	private int foundNum;   //It is used to record the number of building which insert in this test process
	private Building building;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Loading the configure file....");
		ApplicationContext context = new FileSystemXmlApplicationContext( new String[]
				{"src/ApplicationContext.xml","src/ApplicationContext-Building.xml"});
		System.out.println("Loaded succeed....");
		service = (BuildingService) context.getBean("buildingService");
		
	}
	
	
	public testBuildingService(){
		foundNum = 7;
		building = new Building();
	    building.setBuildingCompus("TestingCompus");
	    building.setBuildingFloorNum(2);
	    building.setBuildingName("TestingBuilding");
	    building.setBuildingSimpleName("TB");
	    building.setBuildingDepartment("testingDepartment");
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
		    System.out.println(foundNum);
		    building.setBuildingId(foundNum);
		    
		    assertEquals( building.getBuildingCompus() , tempBuilding.getBuildingCompus() );
		    assertEquals( building.getBuildingDepartment() , tempBuilding.getBuildingDepartment() );
		    assertEquals( building.getBuildingFloorNum() , tempBuilding.getBuildingFloorNum() );
		    assertEquals( building.getBuildingName() , tempBuilding.getBuildingName() );
		}catch( Exception e ){
			e.printStackTrace();
		}
	}


	@Test
	public void testfindbyId() {
		try {
			Building tempBuilding = new Building();
			List<Integer> testList = new ArrayList<Integer>();
			testList.add(foundNum);
			
			System.out.println("The find by buildingId method for BuildingService is to be tested....");
			tempBuilding = service.find(foundNum);
			
		    assertEquals( building.getBuildingCompus() , tempBuilding.getBuildingCompus() );
		    assertEquals( building.getBuildingDepartment() , tempBuilding.getBuildingDepartment() );
		    assertEquals( building.getBuildingFloorNum() , tempBuilding.getBuildingFloorNum() );
		    assertEquals( building.getBuildingName() , tempBuilding.getBuildingName() );
			
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
			testList.add(foundNum);
			assertTrue( service.delete(testList) );

		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}
*/
