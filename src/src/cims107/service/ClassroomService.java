package cims107.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
    	
    	DetachedCriteria dc = DetachedCriteria.forClass(Classroom.class);
		
		if (!type.isEmpty()) {
			dc.add(Restrictions.eq("clsType",type));
		}
		if (floor > 0) {
			dc.add(Restrictions.eq("clsFloor",floor));
		}
		if (!serialnumber.isEmpty()) {
			dc.add(Restrictions.eq("clsSerialNumber",serialnumber));
		}
		if (area > 0) {
			dc.add(Restrictions.eq("clsArea",area));
		}
		if (!location.isEmpty()) {
			dc.add(Restrictions.eq("clsLocation",location));
		}
		if (isamphi == 2 || isamphi == 1) {
			dc.add(Restrictions.eq("clsIsAmphi",isamphi));
		}
		if (!shape.isEmpty()) {
			dc.add(Restrictions.eq("clsShape",shape));
		}
		if (hasmicrophone == 2 || hasmicrophone == 1) {
			dc.add(Restrictions.eq("clsHasMicrophone",hasmicrophone));
		}
		if (!usage.isEmpty()) {
			dc.add(Restrictions.eq("clsUsage",usage));
		}
		if (isused == 2 || isused == 1) {
			dc.add(Restrictions.eq("clsIsUsed",isused));
		}
		if (maxClassNum != 0) {
			if (minClassNum != 0)
				dc.add(Restrictions.between("clsClassNum", minClassNum, maxClassNum));
			else
				dc.add(Restrictions.le("clsClassNum", new Integer(maxClassNum)));
		}
		if (maxClassNum == 0) {
			if (minClassNum != 0)
				dc.add(Restrictions.ge("clsClassNum", new Integer(minClassNum)));
		}
		if (maxExamNum != 0) {
			if (minExamNum != 0)
				dc.add(Restrictions.between("clsExamNum", minExamNum, maxExamNum));
			else
				dc.add(Restrictions.le("clsExamNum", new Integer(maxExamNum)));
		}
		if (maxExamNum == 0) {
			if (minExamNum != 0)
				dc.add(Restrictions.ge("clsExamNum", new Integer(minExamNum)));
		}
    	
    	return classroomDao.find(compus, departmentname, buildingname, dc);
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
    
    public List<Classroom> find() {
    	return classroomDao.find();
    }
    
    public void add(Classroom classroom) {
    	classroomDao.add(classroom);
    }
    
    public void update(Classroom classroom) {
    	classroomDao.update(classroom);
    }
    
    public Boolean delete(List<Integer> clsidlst) {
    	return classroomDao.delete(clsidlst);
    }
}
