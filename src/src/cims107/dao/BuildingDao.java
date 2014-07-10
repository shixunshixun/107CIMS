package cims107.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cims107.model.Building;

public class BuildingDao {
	
	private SessionFactory sessionFactory;

	public List<Building> find(String buildingname, String departmentname, String simplename, String compus) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Building AS b WHERE b.buildingname = :buildingname AND b.departmentname = :departmentname AND"
				+ "b.simplename = :simplename AND b.compus = :compus";
		Query q = session.createQuery(hql);
		
		q.setString("buildingname", buildingname);
		q.setString("departmentname", departmentname);
		q.setString("simplename", simplename);
		q.setString("compus", compus);
		
		List<Building> list = q.list();
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
