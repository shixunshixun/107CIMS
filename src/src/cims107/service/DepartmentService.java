package cims107.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cims107.dao.DepartmentDao;
import cims107.model.Building;
import cims107.model.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> find(String departmentid, String departmentname) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		
		if (!departmentid.isEmpty() && departmentid != null) {
			dc.add(Restrictions.eq("departmentId",departmentid));
		}
		
		if (!departmentname.isEmpty() && departmentname != null) {
			dc.add(Restrictions.like("departmentName", "%"+departmentname+"%"));	
		}
		return departmentDao.find(dc);
	}
}
