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
			dc.add(Restrictions.eq("pYear", pyear));
		if(!pterm.isEmpty())
			dc.add(Restrictions.eq("pTerm", pterm));
		if(!departmentname.isEmpty())
			dc.add(Restrictions.eq("pDepartment", departmentname));
		if (minclassnum > 0)
			dc.add(Restrictions.between("pClassNum", minclassnum, maxclassnum));
		if (minexamnum > 0)
			dc.add(Restrictions.between("pExamNum", minexamnum, maxexamnum));
		if (beginweek > 0)
			dc.add(Restrictions.eq("pBeginWeek", beginweek));
		if (endweek > 0)
			dc.add(Restrictions.eqOrIsNull("pEndWeek", endweek));
		if (pisused == 1 || pisused == 2)
			dc.add(Restrictions.eqOrIsNull("pIsUsed", pisused));
		
		Criteria c = dc.getExecutableCriteria(session);

		
		List<Partition> list = c.list();
		Iterator<Partition> iter = list.iterator();
		
		
		while (iter.hasNext()) {
			if(!type.isEmpty()) {
				if(!iter.next().getClassroom().getClsType().equals(type)) {
					iter.remove();
					continue;
				}
			}
			if(!serialnumber.isEmpty()) {
				if(!iter.next().getClassroom().getClsSerialNumber().equals(serialnumber)) {
					iter.remove();
					continue;
				}
			}
			if(iter.next().getClassroom().getClsAvailableSeatNum() > maxavailableseat ||
					iter.next().getClassroom().getClsAvailableSeatNum() < minavailableseat) {
				iter.remove();
				continue;
			}
			if(!buildingname.isEmpty()) {
				if(!iter.next().getClassroom().getBuilding().getBuildingName().equals(buildingname)) {
					iter.remove();
					continue;
				}
			}
			if(!compus.isEmpty()) {
				if(!iter.next().getClassroom().getBuilding().equals(compus)) {
					iter.remove();
					continue;
				}
			}
			if (type.isEmpty() && serialnumber.isEmpty() && buildingname.isEmpty() && buildingname.isEmpty() 
					&& compus.isEmpty() && iter.next().getClassroom().getClsAvailableSeatNum() >= minavailableseat && 
					iter.next().getClassroom().getClsAvailableSeatNum() <= maxavailableseat) {
				Partition temp = iter.next();
			}
			else
				break;
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
