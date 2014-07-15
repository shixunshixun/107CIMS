package cims107.service;

import cims107.dao.DepartmentDao;
import cims107.model.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public Department find(String departmentid) {
		return departmentDao.find(departmentid);
	}
}
