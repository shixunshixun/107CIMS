package cims107.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;

public class PartitionDao {
	private SessionFactory sessionFactory;
	
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
	
	public List<Partition> find(String pyear, String compus, String buildingname, String pterm, String serialnumber, 
			String departmentname, String type, int maxavailableseat, int minavailableseat, 
			int maxclassnum, int minclassnum, int maxexamnum, int minexamnum, 
			int beginweek, int endweek, int pisused) {
		
		Session session = sessionFactory.openSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Partition.class);
		
		if(!pyear.isEmpty())
			dc.add(Restrictions.eq("partitionYear", pyear));
		if(!pterm.isEmpty())
			dc.add(Restrictions.eq("partitionTerm", pterm));
		if(!departmentname.isEmpty())
			dc.add(Restrictions.eq("partitionDepartment", departmentname));
		if (maxclassnum != 0) {
			if (minclassnum != 0)
				dc.add(Restrictions.between("clsClassNum", minclassnum, maxclassnum));
			else
				dc.add(Restrictions.le("clsClassNum", new Integer(maxclassnum)));
		}
		if (maxclassnum == 0) {
			if (minclassnum != 0)
				dc.add(Restrictions.ge("clsClassNum", new Integer(minclassnum)));
		}
		
		if (maxexamnum != 0) {
			if (minexamnum != 0)
				dc.add(Restrictions.between("clsExamNum", minexamnum, maxexamnum));
			else
				dc.add(Restrictions.le("clsExamNum", new Integer(maxexamnum)));
		}
		if (maxexamnum == 0) {
			if (minexamnum != 0)
				dc.add(Restrictions.ge("clsExamNum", new Integer(minexamnum)));
		}
		if (endweek != 0) {
			if (beginweek != 0) {
				dc.add(Restrictions.between("partitionBeginWeek", beginweek, endweek));
				dc.add(Restrictions.between("partitionEndWeek", beginweek, endweek));
			}
			else {
				dc.add(Restrictions.le("partitionBeginWeek", new Integer(endweek)));
				dc.add(Restrictions.le("partitionEndWeek", new Integer(endweek)));
			}
		}
		if (endweek == 0) {
			if (beginweek != 0) {
				dc.add(Restrictions.ge("partitionBeginWeek", new Integer(beginweek)));
				dc.add(Restrictions.ge("partitionEndWeek", new Integer(beginweek)));
			}
		}
		if (pisused == 1 || pisused == 2)
			dc.add(Restrictions.eqOrIsNull("partitionIsUsed", pisused));
		
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
			/*if (type.isEmpty() && serialnumber.isEmpty() && buildingname.isEmpty() && buildingname.isEmpty() 
					&& compus.isEmpty() && temp.getClassroom().getClsAvailableSeatNum() >= minavailableseat && 
							temp.getClassroom().getClsAvailableSeatNum() <= maxavailableseat) {
				Partition temp = iter.next();
			}
			else
				break;*/
		}
		
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
	
	public void add(Partition partition) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(partition);
		tx.commit();
		session.close();
	}
	
	public Boolean update(Partition partition) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Partition p = (Partition) session.get(Partition.class, partition.getPartitionId());
		
		p.setPartitionYear(partition.getPartitionYear());
		p.setPartitionTerm(partition.getPartitionTerm());
		p.setPartitionBeginWeek(partition.getPartitionBeginWeek());
		p.setPartitionEndWeek(partition.getPartitionEndWeek());
		p.setPartitionDepartment(partition.getPartitionDepartment());
		
		session.update(p); 
		tx.commit();
		session.close();
		
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
			p.setPartitionIsUsed(0);
			session.update(p);
		}
		
		tx.commit();
		session.close();
	}
	
	public Boolean delete(List<Integer> partitionlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (int i = 0; i < partitionlst.size(); i ++) {
			Partition p = (Partition) session.get(Partition.class, partitionlst.get(i));
			session.delete(p);
		}
		
		
		tx.commit();
		session.close();
		
		return true;
	}
}
