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
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cims107.service.BuildingService;
import cims107.service.UserService;
import cims107.dao.BuildingDao;
import cims107.model.Building;
import cims107.model.User;



public class BuildingDaoTest extends AbstractTransactionalDataSourceSpringContextTests {
	private Building building;
	private static BuildingDao buildingDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Loading the configure file....");
		ApplicationContext context = new FileSystemXmlApplicationContext( new String[]
				{"src/ApplicationContext-Testing.xml"});
		System.out.println("Loaded succeed....");
		buildingDao = (BuildingDao) context.getBean("buildingDao");
		
	}
	
	protected String[] getConfigLocations() {
		return new String[] {"src/ApplicationContext-Testing.xml"};
	}
	
	public BuildingDaoTest(){
		building = new Building();
	    building.setBuildingCompus("TCompus");
	    building.setBuildingFloorNum(2);
	    building.setBuildingName("TBuilding");
	    building.setBuildingSimpleName("TB");
	    building.setBuildingDepartment("testingDepartment");
	    System.out.println("loading");
		buildingDao = (BuildingDao) applicationContext.getBean("buildingDao");
	}

	@Test
	public void testadd() {
  
			System.out.println("The add method for BuildingService is to be tested....");
			if( buildingDao == null ) System.out.println("null");
			assertTrue( buildingDao.add(building) );
					
	}
	
}*/