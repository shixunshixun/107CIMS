package cims107.service;

import cims107.dao.BuildingDao;

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
}
