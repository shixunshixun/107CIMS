package cims107.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		
		String hql = "FROM Partition AS p WHERE p.pYear = :pyear AND p.pTerm = :pterm AND p.pDepartment = :departmentname AND"
				+ " p.pClassNum <= :maxclassnum AND p.pClassNum >= :minclassnum AND p.pExamNum <= :maxexamnum AND"
				+ " p.pExamNum >= :minexamnum AND p.pBeginWeek = :beginweek AND p.pEndWeek = :endweek AND p.pIsUsed = :pisused";
		
		Query q = session.createQuery(hql);
		
		q.setString("pyear", pyear);
		q.setString("pterm", pterm);
		q.setString("departmentname", departmentname);
		q.setInteger("maxclassnum", maxclassnum);
		q.setInteger("minclassnum", minclassnum);
		q.setInteger("maxexamnum", maxexamnum);
		q.setInteger("minexamnum", minexamnum);
		q.setInteger("beginweek", beginweek);
		q.setInteger("endweek", endweek);
		q.setInteger("pisused", pisused);
		
		List<Partition> list = q.list();
		session.close();
		
		List<Partition> result = new ArrayList<Partition>();
		
		for (int i = 0; i < list.size(); i ++) {
			if (list.get(i).getClassroom().getClsType().equals(type) && 
					list.get(i).getClassroom().getClsSerialNumber().equals(serialnumber) && 
					list.get(i).getClassroom().getClsAvailableSeatNum() <= maxavailableseat && 
					list.get(i).getClassroom().getClsAvailableSeatNum() >= minavailableseat && 
					list.get(i).getClassroom().getBuilding().getBuildingName().equals(buildingname) && 
					list.get(i).getClassroom().getBuilding().getBuildingCompus().equals(compus)) {
				result.add(list.get(i));
			}
		}
		
		if (result.size()==0)
			return null;
		else
			return result;
	}
	
	public void add(Partition partition) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(partition);
		tx.commit();
		session.close();
	}
	
	public Boolean update(int pid, String pyear, String pterm, int beginweek, int endweek, String pdepartmentname) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Partition p = (Partition) session.get(Partition.class, pid);
		
		p.setPartitionYear(pyear);
		p.setPartitionTerm(pterm);
		p.setPartitionBeginWeek(beginweek);
		p.setPartitionEndWeek(endweek);
		p.setPartitionDepartment(pdepartmentname);
    	
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
