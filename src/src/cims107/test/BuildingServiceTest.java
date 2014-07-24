package cims107.test;

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

public class BuildingServiceTest extends AbstractTransactionalSpringContextTests {
	@Autowired
	public static BuildingService service;
	private int foundNum;   //It is used to record the number of building which insert in this test process
	private Building building;
	
	
	public BuildingServiceTest(){
		foundNum = 7;
		building = new Building();
	    building.setBuildingCompus("TestingCompus");
	    building.setBuildingFloorNum(2);
	    building.setBuildingName("TestingBuilding");
	    building.setBuildingSimpleName("TB");
	    building.setBuildingDepartment("testingDepartment");
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {"classpath:ApplicationContext-Testing.xml","classpath:ApplicationContext-Building.xml"};
	}


	
	public void testadd() {

			System.out.println("The add method for BuildingService is to be tested....");
			assertTrue( service.add(building) );
					
	}
	
}