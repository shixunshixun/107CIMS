package cims107.service;

import cims107.dao.BuildingDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
    	
    	DetachedCriteria dc = DetachedCriteria.forClass(Building.class);
		
		if (!buildingname.isEmpty()) {
			dc.add(Restrictions.eq("buildingName",buildingname));
		}
	
		if (!departmentname.isEmpty()) {	
			dc.add(Restrictions.eq("buildingDepartment", departmentname));	
		}
	
		if (!simplename.isEmpty()) {	
			dc.add(Restrictions.eq("buildingSimpleName", simplename));	
		}
		
		if (!compus.isEmpty()) {
			dc.add(Restrictions.eq("buildingCompus", compus));	
		}
		return buildingDao.find(dc);
    }
    
    //根据一个id链表查找building链表
    public List<Building> find(List<Integer> buildingIdlst) {
    	List<Building> lst = new ArrayList<Building>();
    	
    	for (int i = 0; i < buildingIdlst.size(); i ++) {
    		lst.add(buildingDao.find(buildingIdlst.get(i)));
    	}
    	
    	return lst;
    }
    
    public Building find(String buildingname, String compus) {
    	return buildingDao.find(buildingname, compus);
    }
    
    public Building find(int buildingid) {
    	return buildingDao.find(buildingid);
    }
    
    public boolean add(Building building) {
    	return buildingDao.add(building);
    }
    
    public boolean update(Building building) {
    	return buildingDao.update(building);
    }
    
    public boolean delete(List<Integer> buildingidlst) {
    	if (buildingidlst != null)
    		return buildingDao.delete(buildingidlst);
    	return false;
    }
}
