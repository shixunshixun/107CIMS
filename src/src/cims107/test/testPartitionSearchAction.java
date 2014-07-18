package cims107.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cims107.action.PartitionSearchAction;
import cims107.dao.PartitionDao;
import cims107.model.*;
import cims107.service.*;

import org.apache.coyote.Request;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
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


public class testPartitionSearchAction extends AbstractModelAndViewTests{
	public static PartitionService partition_service;
	public PartitionSearchAction action;

	
	@Test
	public void testExectue() {
		try{
			System.out.println("The exectue method for PartitionSearchAction is to be tested....");
			
			MockHttpServletRequest request = new MockHttpServletRequest();
			MockHttpSession session = new MockHttpSession();
			request.setSession(session);
			request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
			
		    action = new PartitionSearchAction();
		    partition_service = EasyMock.createMock(PartitionService.class);
		    action.setPartitionService(partition_service);
		    
		    action.beginweek = 1;
		    action.buildingname = "TestingBuilding";
		    action.departmentname = "TestingDepartment";
		    action.endweek = 5;
		    action.maxavailableseat = 100;
		    action.maxclassnum = 100;
		    action.maxexamnum = 100;
		    action.minclassnum = 50;
		    action.minavailableseat = 50;
		    action.minexamnum = 50;
		    action.pisused = true;
		    action.pterm = "first";
		    action.pyear = "2014";
		    action.serialnumber = "123";
		    action.type = "TestingType";
	    	
		    Partition partition = new Partition();
		    partition.setpBeginDate(new Date(2014,1,1));
		    partition.setpBeginLession(1);
		    partition.setpBeginWeek(1);
		    partition.setpClassNum(3);
		    partition.setpClsId(1);
		    partition.setpDepartment("TestingDepartment");
		    partition.setpEndDate(new Date(2014,1,31));
		    partition.setpEndLession(3);
		    partition.setpEndWeek(5);
		    partition.setpExamNum(100);
		    partition.setpId(1);
		    partition.setpIsUsed(true);
		    partition.setpTerm("first");
		    partition.setpYear("2014");
		    
		    List<Partition> partitionlst = new ArrayList<Partition>();
		    partitionlst.add(partition);
		    
	    	EasyMock.expect(partition_service.find(EasyMock.anyString(), 
	    			EasyMock.anyString(), EasyMock.anyString(),
	    			EasyMock.anyString(), EasyMock.anyString(), 
	    			EasyMock.anyString(), EasyMock.anyInt(), 
	    			EasyMock.anyInt(), EasyMock.anyInt(), 
	    			EasyMock.anyInt(), EasyMock.anyInt(), 
	    			EasyMock.anyInt(), EasyMock.anyInt(), 
	    			EasyMock.anyInt(), EasyMock.anyBoolean())).andReturn(partitionlst);
	    	EasyMock.replay(partition_service);
	    	
	    	assertEquals( "success" , action.execute() );
		
		}catch( Exception e ){
			e.printStackTrace();
		}	

	}

}