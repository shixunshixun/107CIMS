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
	
	public List<Partition> find(String pyear, String buildingname, String pterm, String serialnumber, 
			String departmentname, String type, int maxavailableseat, int minavailableseat, 
			int maxclassnum, int minclassnum, int maxexamnum, int minexamnum, 
			int beginweek, int endweek, Boolean pisused) {
		
		Session session = sessionFactory.openSession();
		String hql = "FROM Partition AS p AND Building AS b AND Classroom As c WHERE p.pYear = :pyear AND b.buildingName = :buildingname AND"
				+ " p.pTerm = :pterm AND c.clsSerialNumber = :serialnumber AND p.pDepartment = :departmentname AND"
				+ " c.clsType = :type AND c.clsAvailableSeatNum <= :maxavailableseat AND c.clsAvailableSeatNum >= :minavailableseat AND"
				+ " p.pClassNum <= :maxclassnum AND p.pClassNum >= :minclassnum AND p.pExamNum <= :maxexamnum AND"
				+ " p.pExamNum >= :minexamnum AND p.pBeginWeek = :beginweek AND p.pEndWeek = :endweek AND p.pIsUsed = :pisused AND"
				+ " p.pClsId = c.clsId AND b.buildingId = c.clsBuildingId";
		Query q = session.createQuery(hql);
		
		q.setString("pyear", pyear);
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
		q.setBoolean("pisused", pisused);
		
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
}
