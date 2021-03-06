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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cims107.service.BuildingService;
import cims107.service.UserService;
import cims107.model.Building;
import cims107.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext-Testing.xml")
@Transactional
public class BuildingServiceTest {
	@Resource
	public BuildingService service;
	private int foundNum;   //It is used to record the number of building which insert in this test process
	private Building building;
	
	
	public BuildingServiceTest(){
		foundNum = 7;
		building = new Building();
	    building.setBuildingCompus("TCompus");
	    building.setBuildingFloorNum(2);
	    building.setBuildingName("TBuilding");
	    building.setBuildingSimpleName("TB");
	    building.setBuildingDepartment("testingDepartment");
	}

	@Test
	@Rollback
	public void testadd() {

			System.out.println("The add method for BuildingService is to be tested....");
			assertTrue( service.add(building) );
					
	}
	
}*/