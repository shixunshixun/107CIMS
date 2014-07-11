package cims107.service;

import cims107.dao.BuildingDao;

import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
 

import jxl.Workbook;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;

import java.util.ArrayList;
import java.util.List;

import cims107.model.Building;

public class BuildingService {
	private BuildingDao buildingDao;

	public BuildingDao getBuildingDao() {  
        return buildingDao;  
    }  
  
    public void setBuildingDao(BuildingDao buildingDao) {  
        this.buildingDao = buildingDao;  
    }
    
    public List<Building> find(String buildingname, String departmentname, String simplename, String compus) {
    	return buildingDao.find(buildingname, departmentname, simplename, compus);
    }
    
    //根据一个id链表查找building链表
    public List<Building> find(List<Integer> buildingIdlst) {
    	List<Building> lst = new ArrayList<Building>();
    	
    	for (int i = 0; i < buildingIdlst.size(); i ++) {
    		lst.add(buildingDao.find(buildingIdlst.get(i)));
    	}
    	
    	return lst;
    }
    
    public boolean add(Building building) {
    	return buildingDao.add(building);
    }
    
    public boolean update(int buildingid, Building building) {
    	return buildingDao.update(buildingid, building);
    }
    
    public boolean delete(List<Integer> buildingidlst) {
    	return buildingDao.delete(buildingidlst);
    }
}
