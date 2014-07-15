package cims107.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cims107.model.Building;
import cims107.model.Department;

public class DepartmentDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Department find(String departmentid) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Department AS d WHERE d.departmentId = :departmentid";
		Query q = session.createQuery(hql);
		
		q.setString("departmentid", departmentid);
		
		List<Department> list = q.list();
		session.close();
		return list.get(0);
	}
}
