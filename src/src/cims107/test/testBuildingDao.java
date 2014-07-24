package cims107.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cims107.dao.*;
import cims107.model.Building;
/*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {"classpath:ApplicationContext.xml","classpath:ApplicationContext-Building.xml" })
@Transactional 
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)  
public class testBuildingDao extends AbstractTransactionalDataSourceSpringContextTests{
	@Resource
    public BuildingDao testDao ;
	
	
	@Test
	public void testadd(){
		testDao = new BuildingDao();
		Building building = new Building();
	    building.setBuildingCompus("TestingCompus");
	    building.setBuildingFloorNum(2);
	    building.setBuildingName("TestingBuilding");
	    building.setBuildingSimpleName("TB");
	    building.setBuildingDepartment("testingDepartment");
	    

	    assertTrue(testDao.add(building));
	    
	}
}*/
