package cims107.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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

public class PartitionDao {
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(PartitionDao.class); 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Partition> find() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Partition";
		Query q = session.createQuery(hql);
		
		List<Partition> list = q.list();
		
		Iterator<Partition> tempiter = list.iterator();
		while (tempiter.hasNext()) {
			Partition testc = tempiter.next();
			String tempcompus = testc.getClassroom().getBuilding().getBuildingCompus();
			String snumber = testc.getClassroom().getClsSerialNumber();
		}
		
		session.close();
		//ªÒ»°buildingId
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public List<Partition> find(String compus, String buildingname,  String serialnumber, 
			String type, int maxavailableseat, int minavailableseat, DetachedCriteria dc) {
		
		Session session = sessionFactory.openSession();
		Criteria c = dc.getExecutableCriteria(session);
		
		List<Partition> list = c.list();
		Iterator<Partition> iter = list.iterator();
		
		Iterator<Partition> tempiter = list.iterator();
		while (tempiter.hasNext()) {
			Partition testc = tempiter.next();
			String tempcompus = testc.getClassroom().getBuilding().getBuildingCompus();
			String snumber = testc.getClassroom().getClsSerialNumber();
		}
		
		while (iter.hasNext()) {
			Partition temp = iter.next();
			if(!type.isEmpty()) {
				if(!temp.getClassroom().getClsType().equals(type)) {
					iter.remove();
					continue;
				}
			}
			if(!serialnumber.isEmpty()) {
				if(!temp.getClassroom().getClsSerialNumber().equals(serialnumber)) {
					iter.remove();
					continue;
				}
			}
			if (maxavailableseat != 0) {
				if (minavailableseat == 0) {
					if (temp.getClassroom().getClsAvailableSeatNum() > maxavailableseat)
						iter.remove();
				}
				if (minavailableseat != 0) {
					if(temp.getClassroom().getClsAvailableSeatNum() > maxavailableseat ||
							temp.getClassroom().getClsAvailableSeatNum() < minavailableseat) {
						iter.remove();
						continue;
					}
				}
			}
			if (maxavailableseat == 0) {
				if (minavailableseat != 0) {
					if (temp.getClassroom().getClsAvailableSeatNum() < minavailableseat)
						iter.remove();
				}
			}
			
			if(!buildingname.isEmpty()) {
				if(!temp.getClassroom().getBuilding().getBuildingName().equals(buildingname)) {
					iter.remove();
					continue;
				}
			}
			if(!compus.isEmpty()) {
				if(!temp.getClassroom().getBuilding().equals(compus)) {
					iter.remove();
					continue;
				}
			}
		}
		
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public void add(Partition partition) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(partition);
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" create partition " + partition.getPartitionId());
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
	
	public Boolean update(Partition partition) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Partition p = (Partition) session.get(Partition.class, partition.getPartitionId());
			
			p.setPartitionYear(partition.getPartitionYear());
			p.setPartitionTerm(partition.getPartitionTerm());
			p.setPartitionBeginWeek(partition.getPartitionBeginWeek());
			p.setPartitionEndWeek(partition.getPartitionEndWeek());
			p.setPartitionBeginDate(partition.getPartitionBeginDate());
			p.setPartitionEndDate(partition.getPartitionEndDate());
			p.setPartitionDepartment(partition.getPartitionDepartment());
			
			session.update(p); 
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" update partition " + partition.getPartitionId());
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
	
	public void enabeUpdate(List<Integer> partitionlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (int i = 0; i < partitionlst.size(); i ++) {
			Partition p = (Partition) session.get(Partition.class, partitionlst.get(i));
			p.setPartitionIsUsed(1);
			session.update(p);
		}
		
		tx.commit();
		session.close();
	}
	
	public void disableUpdate(List<Integer> partitionlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (int i = 0; i < partitionlst.size(); i ++) {
			Partition p = (Partition) session.get(Partition.class, partitionlst.get(i));
			p.setPartitionIsUsed(2);
			session.update(p);
		}
		
		tx.commit();
		session.close();
	}
	
	public Boolean delete(List<Integer> partitionlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < partitionlst.size(); i ++) {
				Partition p = (Partition) session.get(Partition.class, partitionlst.get(i));
				String t = p.getClassroom().getBuilding().getBuildingCompus() + ", " + 
						p.getClassroom().getBuilding().getBuildingName() + ", " +
						p.getClassroom().getClsSerialNumber() + ", " +
						p.getPartitionYear() + ", " + p.getPartitionTerm();
				session.delete(p);
				log.info(ActionContext.getContext().getSession().get("username").toString() + 
						" delete partition (" + t + ")");
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
}
