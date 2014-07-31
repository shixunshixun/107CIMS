package cims107.test;

import cims107.model.*;
import cims107.service.*;

public class temp {
	public void tloginaction() {
		User user = new User();

		user.setUserName("");
		user.setUserPassword("");
		//return error
		
		user.setUserName("sysu1");
		user.setUserPassword("sysu1");
		//return success
		
		user.setUserName("");
		user.setUserPassword("sysu1");
		//return error
		
		user.setUserName("sysu1");
		user.setUserPassword("");
		//return error
	}
	
	public void tbuildingcreateaction() {
		Building TBuilding = new Building();
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//return success
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(0);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//return error
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(-1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//return error
		
		TBuilding.setBuildingCompus("");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//return error
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("");
		TBuilding.setBuildingSimpleName("TB");
		//return error
		
		TBuilding.setBuildingCompus("");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("");
		TBuilding.setBuildingSimpleName("TB");
		//return error
	}
	
	public void tbuildingsearchaction() {
		Building TBuilding = new Building();
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildinglst != null 
		//return true
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildinglst == null 
		//return true
	}
	
	public void tbuildingupdateaction() {
		Building TBuilding = new Building();
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return success
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(0);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return error
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(-1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return error
		
		TBuilding.setBuildingCompus("");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return error
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return error
		
		TBuilding.setBuildingCompus("");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return true
		//return error
		
		TBuilding.setBuildingCompus("TCompus");
		TBuilding.setBuildingDepartment("TDepartment");
		TBuilding.setBuildingFloorNum(1);
		TBuilding.setBuildingId(0);
		TBuilding.setBuildingName("TBuilding");
		TBuilding.setBuildingSimpleName("TB");
		//buildingService.update return false
		//return error
	}
	
	public void tbuildingdeleteaction() {
		String[] buildingid;
		
		buildingid = new String[]{"1"};
		//buildingService.delete return true
		//return success
		
		buildingid = new String[]{};
		//buildingService.delete return false
		//return error
		
	}
	
	public void tbuildingimportaction() {
		
	}
	
	public void tbuildingexportaction() {
		
	}
	
	
	public void tclscreateaction() {
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return null
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(0);                          //
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(0);     //0 is OK
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return ADDSUCCESS
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(-1);     //-1 is wrong
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(0);                  //0 is OK
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(-1);                  //-1 is error
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(100);           //ExamNum is more than seatnum  ,error       
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                
	    TClassroom.setClsClassNum(0);                  //0 is OK
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                 
	    TClassroom.setClsClassNum(-1);                 //-1 is error
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(100);         //ClassNum is more than seatnum  ,error
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(0);               //error
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(-1);               //error
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,6");         //|x-y| != 1, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("-1,-2");         // error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error   
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,10");         //x == y, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("50,51");         //The x or y more than the MaxCol or MaxRow, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,6,3");         //format error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("error");         //error format ,error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");     
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,6");        //|x-y| != 1, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("1,2");        
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("-2,-3");     // error
	    TClassroom.setPartitions(null);
	    //return  error   
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,11");       
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,2");          //x == y, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,11");         
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("50,51");   //The x or y more than the MaxCol or MaxRow, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");      
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3,4");         //format error 
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");         
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("error");         //error format ,error
	    TClassroom.setPartitions(null);
	    //return  error   
	    
	    
	}
	
	public void tclssearchaction() {
		Classroom TClassroom = new Classroom();
	    int maxClassNum;
		int minClassNum;
		int maxExamNum;
		int minExamNum;
		String compus;
	    String departmentname;
		String buildingname;
		
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return success
	    
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    maxClassNum = 0;
		minClassNum = 0;
		maxExamNum = 0;
		minExamNum = 0;
	    //return success
		
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    maxClassNum = 0;
		minClassNum = 0;
		maxExamNum = 0;
		minExamNum = 0;
		//classroomlst not null
		//return success
		
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    maxClassNum = 50;
		minClassNum = 0;
		maxExamNum = 50;
		minExamNum = 0;
		//classroomlst not null
		//return success
		
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    maxClassNum = 0;
		minClassNum = 50;
		maxExamNum = 0;
		minExamNum = 0;
		//classroomlst not null
		//return error
		
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    maxClassNum = 0;
		minClassNum = 0;
		maxExamNum = 0;
		minExamNum = 50;
		//classroomlst not null
		//return success
		 
		
	}
	
	public void tclsupdateaction() {
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return null
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(0);                          //
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(0);     //0 is OK
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return ADDSUCCESS
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(-1);     //-1 is wrong
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(0);                  //0 is OK
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(-1);                  //-1 is error
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(100);           //ExamNum is more than seatnum  ,error       
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                
	    TClassroom.setClsClassNum(0);                  //0 is OK
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  ADDSUCCESS
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                 
	    TClassroom.setClsClassNum(-1);                 //-1 is error
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(100);         //ClassNum is more than seatnum  ,error
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(0);               //error
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(-1);               //error
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,6");         //|x-y| != 1, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("-1,-2");         // error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error   
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,10");         //x == y, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("50,51");         //The x or y more than the MaxCol or MaxRow, error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,6,3");         //format error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("error");         //error format ,error
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    //return  error
	    	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");     
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,6");        //|x-y| != 1, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("1,2");        
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("-2,-3");     // error
	    TClassroom.setPartitions(null);
	    //return  error   
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,11");       
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,2");          //x == y, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("10,11");         
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("50,51");   //The x or y more than the MaxCol or MaxRow, error
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");      
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3,4");         //format error 
	    TClassroom.setPartitions(null);
	    //return  error
	    
	    TBuilding.setBuildingCompus("TestingCompus");
	    TBuilding.setBuildingDepartment("TestingDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TestingBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);                          
	    TClassroom.setClsAvailableSeatNum(50);     
	    TClassroom.setClsExamNum(50);                  
	    TClassroom.setClsClassNum(50);         
	    TClassroom.setClsFloor(50);               
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");         
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("error");         //error format ,error
	    TClassroom.setPartitions(null);
	    //return  error   
	}
	
	public void tclsdeleteaction() {
		String[] clsid;
		
		clsid = new String[]{"1"};
		//buildingService.delete return true
		//return success
		
		clsid = new String[]{};
		//buildingService.delete return false
		//return error
	}
	
	public void tclsimportaction() {
		
	}
	
	public void tclsexportaction() {
		
	}
	
	public void tseatmanageaction() {
		
	}
	
	public void tpcreateaction() {
		String[] whichday; 
		int maxavailableseat;
		int minavailableseat;
		String buildingname;
		String compus;
		String serialnumber;
		Partition partition = new Partition();
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		
		buildingname = "TBuilding";
		compus = "TCompus";
		//the buildingService.find return the unique building
		serialnumber = "123";
		//the classroomService.find return the unique classroom
		//return success
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		
		buildingname = "TBuilding";
		compus = "TCompus";
		//the buildingService.find return null
		serialnumber = "123";
		//the classroomService.find return the unique classroom
		//return error
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		
		buildingname = "TBuilding";
		compus = "TCompus";
		//the buildingService.find return the unique building
		serialnumber = "123";
		//the classroomService.find return null
		//return error
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(15);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //Begin more than end
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		
		buildingname = "TBuilding";
		compus = "TCompus";
		//the buildingService.find return the unique building
		serialnumber = "123";
		//the classroomService.find return the unique classroom
		//return error
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(20);   //begin more than end
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		
		buildingname = "TBuilding";
		compus = "TCompus";
		//the buildingService.find return the unique building
		serialnumber = "123";
		//the classroomService.find return the unique classroom
		//return error
		
		
		
	}
	
	public void tpdeleteaction() {
		String[] partitionid;
		
		partitionid = new String[]{"1"};
		//buildingService.delete return true
		//return success
		
		partitionid = new String[]{};
		//buildingService.delete return false
		//return error
	}
	
	public void tpdisableaction() {
		String[] partitionid;
		
		partitionid = new String[]{"1"};
		//buildingService.delete return true
		//return success
		
		partitionid = new String[]{};
		//buildingService.delete return false
		//return error
	}
	
	public void tpenableaction() {
		String[] partitionid;
		
		partitionid = new String[]{"1"};
		//buildingService.delete return true
		//return success
		
		partitionid = new String[]{};
		//buildingService.delete return false
		//return error
	}
	
	public void tpsearchaction() {
		int maxavailableseat;
		int minavailableseat;
		int maxclassnum;
		int minclassnum;
		int maxexamnum;
		int minexamnum;
		String buildingname;
		String serialnumber;	
	    String compus;
	    
		Partition partition = new Partition();
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		//the partitionService.find return the list
		//return success
		
		//the partitionService.find return null
		//return error
	    
	}
	
	
	
	public void tpsearchallaction() {
		Partition partition = new Partition();
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		//the partitionService.find return the list
		//return success
		
		//the partitionService.find return null
		//return success
	}
	
	public void tpupdateaction() {
		Partition partition = new Partition();
		Classroom TClassroom = new Classroom();
		Building TBuilding = new Building();
		
	    TBuilding.setBuildingCompus("TCompus");
	    TBuilding.setBuildingDepartment("TDepartment");
	    TBuilding.setBuildingFloorNum(2);
	    TBuilding.setBuildingId(1);
	    TBuilding.setBuildingName("TBuilding");
	    TBuilding.setBuildingSimpleName("TB");
	    //buildingService.find return an unique building
	    TClassroom.setClsArea(50);
	    TClassroom.setClsAvailableSeatNum(50);
	    TClassroom.setClsExamNum(50);
	    TClassroom.setClsClassNum(50);
	    TClassroom.setClsFloor(3);
	    TClassroom.setClsHasMicrophone(1);
	    TClassroom.setClsHCorridorLocate("2,3");
	    TClassroom.setClsId(1);
	    TClassroom.setClsIsAmphi(1);
	    TClassroom.setClsIsUsed(1);
	    TClassroom.setClsLocation("12");
	    TClassroom.setClsMaxCol(50);
	    TClassroom.setClsMaxRow(50);
	    TClassroom.setClsSeatNum(50);
	    TClassroom.setClsSerialNumber("123");
	    TClassroom.setClsShape("");
	    TClassroom.setClsType("");
	    TClassroom.setClsUsage("");
	    TClassroom.setClsVCorridorLocate("2,3");
	    TClassroom.setPartitions(null);
	    
		partition.setClassroom(TClassroom);
		partition.setPartitionBeginDate("partitionBeginDate");
		partition.setPartitionBeginLession(12);   //
		partition.setPartitionBeginWeek(1);    //
		partition.setPartitionClassNum(50);   //
		partition.setPartitionDepartment("partitionDepartment");
		partition.setPartitionEndDate("partitionEndDate");
		partition.setPartitionEndLession(15);  //
		partition.setPartitionEndWeek(10);   //
		partition.setPartitionExamNum(50);   //
		partition.setPartitionId(1);
		partition.setPartitionIsUsed(1);
		partition.setPartitionTerm("partitionTerm");
		partition.setPartitionWhichDay("123");
		partition.setPartitionYear("partitionYear");
		//the partitionService.update return true
		//return success
		
		//the partitionService.find return false
		//return error
	}
	
	public void tdepartmentsearch() {
		Department department = new Department();
		department.setDepartmentId("123");
		department.setDepartmentName("TDepartment");
		//return true
		
		
	}
}