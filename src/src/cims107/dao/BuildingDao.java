package cims107.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;

import cims107.action.BuildingCreateAction;
import cims107.model.Building;

public class BuildingDao {
	
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(BuildingDao.class); 

	public List<Building> find(DetachedCriteria dc) {
		Session session = sessionFactory.openSession();
	   
		Criteria c = dc.getExecutableCriteria(session);
	
		List<Building> list = c.list();
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public Building find(String buildingname, String compus) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Building AS b WHERE b.buildingName = :buildingname AND b.buildingCompus = :compus";
		Query q = session.createQuery(hql);
		
		q.setString("buildingname", buildingname);
		q.setString("compus", compus);
		
		List<Building> list = q.list();
		session.close();
		//��ȡbuildingId
		// in case find nothing
		if (list.size()==0)
			return null;
		else
			return list.get(0);
		
	}
	
	public Building find(int buildingid) {
		Session session = sessionFactory.openSession();
		
		String hql = "FROM Building AS b WHERE b.buildingId = :buildingid";
		Query q = session.createQuery(hql);
		
		q.setString("buildingid", new Integer(buildingid).toString());
		
		List<Building> list = q.list();
		
		session.close();
		return list.get(0);
	}
	
	//����ѧ¥�����Ƿ�����
	public boolean add(Building building) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(building);
		tx.commit();
		session.close();
		log.info(ActionContext.getContext().getSession().get("username").toString() + 
				" create building " + building.getBuildingId());
		return true;
	}
	
	public boolean update(Building building) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Building b = (Building) session.get(Building.class, building.getBuildingId());
		
		b.setBuildingName(building.getBuildingName());
    	b.setBuildingDepartment(building.getBuildingDepartment());
    	b.setBuildingSimpleName(building.getBuildingSimpleName());
    	b.setBuildingCompus(building.getBuildingCompus());
    	b.setBuildingFloorNum(building.getBuildingFloorNum());
    	
		session.update(b); 
		
		tx.commit();
		session.close();
		
		log.info(ActionContext.getContext().getSession().get("username").toString() + 
				" update building " + building.getBuildingId());
		
		return true;
	}
	
	public boolean delete(List<Integer> buildingidlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (int i = 0; i < buildingidlst.size(); i ++) {
			Building b = (Building) session.get(Building.class, buildingidlst.get(i));
			session.delete(b);
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" delete building (" + b.getBuildingCompus() + ", " + b.getBuildingName() + ")");
		}
		
		tx.commit();
		session.close();
		
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
