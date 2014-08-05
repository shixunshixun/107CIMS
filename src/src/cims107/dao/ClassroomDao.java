package cims107.dao;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;

public class ClassroomDao {
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(ClassroomDao.class); 

	public List<Classroom> find(String compus, String departmentname, String buildingname, DetachedCriteria dc) {
		
		Session session = sessionFactory.openSession();
		Criteria c = dc.getExecutableCriteria(session);
		
		List<Classroom> list = c.list();
		Iterator<Classroom> iter = list.iterator();
		
		Iterator<Classroom> tempiter = list.iterator();
		while (tempiter.hasNext()) {
			Classroom temp = tempiter.next();
			String tempcompus = temp.getBuilding().getBuildingCompus();
		}
		//返回的classroom对象中是数据表中数据，没有building对象属性，要通过clsbuildingid来访问compus和buildingname
		while (iter.hasNext()) {
			Classroom tempclassroom = iter.next();
			if (!compus.isEmpty()) {
				if (!tempclassroom.getBuilding().getBuildingCompus().equals(compus)) {
					iter.remove();
					continue;
				}
			}
			if (!departmentname.isEmpty()) {
				if (!tempclassroom.getBuilding().getBuildingDepartment().equals(departmentname)) {
					iter.remove();
					continue;
				}
			}
			if (!buildingname.isEmpty()) {
				if (!tempclassroom.getBuilding().getBuildingName().equals(buildingname)) {
					iter.remove();
				}
			}
			
			if (compus.isEmpty() && departmentname.isEmpty() && buildingname.isEmpty()) {
				break;
			}
		}

		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public Classroom find(int clsid) {
		Session session = sessionFactory.openSession();
		
		Classroom c = (Classroom) session.get(Classroom.class, clsid);
		
		String tempcompus = c.getBuilding().getBuildingCompus();
		
		session.close();
		
		return c;
	}
	public List<Classroom> find() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Classroom";
		Query q = session.createQuery(hql);
		
		List<Classroom> list = q.list();
		
		Iterator<Classroom> tempiter = list.iterator();
		while (tempiter.hasNext()) {
			Classroom testc = tempiter.next();
			String tempcompus = testc.getBuilding().getBuildingCompus();
		}
		
		session.close();
		//获取buildingId
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public Classroom find(int clsbuildingid, String serialnumber) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Classroom AS c WHERE c.clsSerialNumber = :serialnumber";
		Query q = session.createQuery(hql);
		
		q.setString("serialnumber", serialnumber);
		
		List<Classroom> list = q.list();
		Iterator<Classroom> iter = list.iterator();
		
		while (iter.hasNext()) {
			if (iter.next().getBuilding().getBuildingId() != clsbuildingid)
				iter.remove();
		}
		session.close();
		
		//锟斤拷取buildingId
		if (list.size()==0)
			return null;
		return list.get(0);
	}
	
	//锟斤拷锟斤拷学楼锟斤拷锟斤拷锟角凤拷锟斤拷锟斤拷
	public void add(Classroom classroom) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(classroom);
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" create classroom " + classroom.getClsId());
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
	
	public void update(Classroom classroom) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Classroom c = (Classroom) session.get(Classroom.class, classroom.getClsId());
			
			c.setClsSerialNumber(classroom.getClsSerialNumber());
	    	c.setClsFloor(classroom.getClsFloor());
	    	c.setClsType(classroom.getClsType());
	    	c.setClsShape(classroom.getClsShape());
	    	c.setClsClassNum(classroom.getClsClassNum());
	    	c.setClsExamNum(classroom.getClsExamNum());
	    	c.setClsMaxRow(classroom.getClsMaxRow());
	    	c.setClsMaxCol(classroom.getClsMaxCol());
	    	c.setClsHCorridorLocate(classroom.getClsHCorridorLocate());
	    	c.setClsVCorridorLocate(classroom.getClsVCorridorLocate());
	    	c.setClsArea(classroom.getClsArea());
	    	c.setClsLocation(classroom.getClsLocation());
	    	c.setClsIsAmphi(classroom.getClsIsAmphi());
	    	c.setClsHasMicrophone(classroom.getClsHasMicrophone());
	    	c.setClsIsUsed(classroom.getClsIsUsed());
	    	c.setClsUsage(classroom.getClsUsage());
	    	c.setClsSeatNum(classroom.getClsSeatNum());
	    	c.setClsAvailableSeatNum(classroom.getClsAvailableSeatNum());
	    	//c.setBuilding(classroom.getBuilding());
	    	
			session.update(c); 
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" update classroom " + classroom.getClsId());
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
	
	public Boolean delete(List<Integer> clsidlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < clsidlst.size(); i ++) {
				Classroom b = (Classroom) session.get(Classroom.class, clsidlst.get(i));
				String t = b.getBuilding().getBuildingCompus() + ", " + 
						b.getBuilding().getBuildingName() + ", " + b.getClsSerialNumber();
				session.delete(b);
				log.info(ActionContext.getContext().getSession().get("username").toString() + 
						" delete classroom (" + t + ")");
			}
			
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
		
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
