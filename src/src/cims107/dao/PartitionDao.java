package cims107.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
			String beginweek, String endweek, Boolean pisused) {
		
		Session session = sessionFactory.openSession();
		String hql = "FROM Partition AS p AND Building AS b AND Classroom As c WHERE p.pYear = :pyear AND b.buildingName = :buildingname AND"
				+ " p.pTerm = :pterm AND c.clsSerialNumber = :serialnumber AND p.pDepartment = :departmentname AND"
				+ " c.clsType = :type AND c.clsAvailableSeatNum <= :maxavailableseat AND c.clsAvailableSeatNum >= :minavailableseat AND"
				+ " c.clsClassNum <= :maxclassnum AND c.clsClassNum >= :minclassnum AND c.clsExamNum <= :maxexamnum AND"
				+ " c.clsExamNum >= :minexamnum AND p.pBeginWeek = :beginweek AND p.pEndWeek = :endweek AND p.pIsUsed = :pisused AND"
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
		
		q.setString("beginweek", beginweek);
		q.setString("endweek", endweek);
		q.setBoolean("pisused", pisused);
		
		List<Partition> list = q.list();
		session.close();
		if (list.size()==0)
			return null;
		else
			return list;
	}
}
