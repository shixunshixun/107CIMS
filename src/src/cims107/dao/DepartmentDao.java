package cims107.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

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
	
	public List<Department> find(DetachedCriteria dc) {
		Session session = sessionFactory.openSession();
		   
		Criteria c = dc.getExecutableCriteria(session);
	
		List<Department> list = c.list();
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
}
