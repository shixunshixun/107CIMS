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
    
    public List<Building> find(List<Integer> buildinglst) {
    	List<Building> lst = new ArrayList<Building>();
    	
    	for (int i = 0; i < buildinglst.size(); i ++) {
    		lst.add(buildingDao.find(buildinglst.get(i)));
    	}
    	
    	return lst;
    }
    
    public void add(Building building) {
    	buildingDao.add(building);
    }
    
    public void update(int buildingid, Building building) {
    	buildingDao.update(buildingid, building);
    }
    
    public void delete(List<Integer> buildingidlst) {
    	buildingDao.delete(buildingidlst);
    }
}
