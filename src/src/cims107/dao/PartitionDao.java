package cims107.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cims107.model.Building;
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
		return list;
	}
	
	public List<Partition> find(String pyear, String compus, String buildingname, String pterm, String serialnumber, 
			String departmentname, String type, int maxavailableseat, int minavailableseat, 
			int maxclassnum, int minclassnum, int maxexamnum, int minexamnum, 
			int beginweek, int endweek, int pisused) {
		
		Session session = sessionFactory.openSession();
		/*String hql = "FROM Partition AS p, Building AS b, Classroom As c WHERE p.pYear = :pyear AND b.buildingName = :buildingname AND"
				+ " p.pTerm = :pterm AND c.clsSerialNumber = :serialnumber AND p.pDepartment = :departmentname AND"
				+ " c.clsType = :type AND c.clsAvailableSeatNum <= :maxavailableseat AND c.clsAvailableSeatNum >= :minavailableseat AND"
				+ " p.pClassNum <= :maxclassnum AND p.pClassNum >= :minclassnum AND p.pExamNum <= :maxexamnum AND"
				+ " p.pExamNum >= :minexamnum AND p.pBeginWeek = :beginweek AND p.pEndWeek = :endweek AND p.pIsUsed = :pisused AND"
				+ " p.pClsId = c.clsId AND b.buildingId = c.clsBuildingId";*/
		
		String hql = "FROM Partition AS p WHERE p.pYear = :pyear AND p.pTerm = :pterm AND p.pDepartment = :departmentname AND"
				+ " p.pClassNum <= :maxclassnum AND p.pClassNum >= :minclassnum AND p.pExamNum <= :maxexamnum AND"
				+ " p.pExamNum >= :minexamnum AND p.pBeginWeek = :beginweek AND p.pEndWeek = :endweek AND p.pIsUsed = :pisused AND"
				+ " p.pClsId in (select clsId from Classroom where clsType=:type and clsSerialNumber=:serialnumber and"
				+ " clsAvailableSeatNum<=:maxavailableseat and clsAvailableSeatNum>=:minavailableseat and clsBuildingId in "
				+ " (select buildingId from Building where buildingName=:buildingname and buildingCompus=:compus))";
		
		
		
		Query q = session.createQuery(hql);
		
		q.setString("pyear", pyear);
		q.setString("compus", compus);
		q.setString("buildingname", buildingname);
		q.setString("pterm", pterm);
		q.setString("serialnumber", serialnumber);
		
		q.setString("departmentname", departmentname);
		q.setString("type", type);
		q.setInteger("maxavailableseat", maxavailableseat);
		q.setInteger("minavailableseat", minavailableseat);
		
		q.setInteger("maxclassnum", maxclassnum);
		q.setInteger("minclassnum", minclassnum);
		q.setInteger("maxexamnum", maxexamnum);
		q.setInteger("minexamnum", minexamnum);
		
		q.setInteger("beginweek", beginweek);
		q.setInteger("endweek", endweek);
		q.setInteger("pisused", pisused);
		
		List<Partition> list = q.list();
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
	
	public Boolean update(int pid, String pyear, String pterm, int beginweek, int endweek, String pdepartmentname) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Partition p = (Partition) session.get(Partition.class, pid);
		
		p.setpYear(pyear);
		p.setpTerm(pterm);
		p.setpBeginWeek(beginweek);
		p.setpEndWeek(endweek);
		p.setpDepartment(pdepartmentname);
    	
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
			p.setpIsUsed(1);
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
			p.setpIsUsed(0);
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
