package cims107.service;

import java.util.ArrayList;
import java.util.List;

import cims107.dao.ClassroomDao;
import cims107.model.Classroom;

public class ClassroomService {
	private ClassroomDao classroomDao;

	public ClassroomDao getClassroomDao() {  
        return classroomDao;  
    }  
  
    public void setClassroomDao(ClassroomDao classroomDao) {  
        this.classroomDao = classroomDao;  
    }
    
    public List<Classroom> find(String compus, String departmentname, String type, String buildingname, 
			int floor, String serialnumber, int minClassNum, int maxClassNum, 
			int area, int minExamNum, int maxExamNum, String location, 
			int isamphi, String shape, int hasmicrophone, String usage, int isused) {
    	
    	return classroomDao.find(compus, departmentname, type, buildingname, 
				floor, serialnumber, minClassNum, maxClassNum, 
				area, minExamNum, maxExamNum, location, 
				isamphi, shape, hasmicrophone, usage, isused);
    }
    
    public List<Classroom> find(List<Integer> classroomIdlst) {
    	List<Classroom> lst = new ArrayList<Classroom>();
    	Classroom c;
    	
    	for (int i = 0; i < classroomIdlst.size(); i ++) {
    		c = classroomDao.find(classroomIdlst.get(i));
    		if(c != null) {
    			lst.add(c);
    		}
    	}
    	
    	return lst;
    }
    
    public Classroom find(int clsbuildingid, String serialnumber) {
    	return classroomDao.find(clsbuildingid, serialnumber);
    }
    
    public void add(Classroom classroom) {
    	classroomDao.add(classroom);
    }
    
    public void update(int clsid, String buildingname, String departmentname,  Classroom classroom) {
    	classroomDao.update(clsid, buildingname, departmentname, classroom);
    }
    
    public Boolean delete(List<Integer> clsidlst) {
    	return classroomDao.delete(clsidlst);
    }
}
