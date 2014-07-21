package cims107.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cims107.model.Building;
import cims107.model.Classroom;
import cims107.model.Partition;

public class ClassroomDao {
	private SessionFactory sessionFactory;

	public List<Classroom> find(String compus, String departmentname, String type, String buildingname, 
			int floor, String serialnumber, int minClassNum, int maxClassNum, 
			int area, int minExamNum, int maxExamNum, String location, 
			int isamphi, String shape, int hasmicrophone, String usage, int isused) {
		
		Session session = sessionFactory.openSession();
		
		String hql = "FROM Classroom AS c WHERE c.clsType = :type AND c.clsFloor = :floor AND"
				+ " c.clsSerialNumber = :serialnumber AND c.clsClassNum >= :minClassNum AND c.clsClassNum <= :maxClassNum AND"
				+ " c.clsArea = :area AND c.clsExamNum >= :minExamNum AND c.clsExamNum <= :maxExamNum AND"
				+ " c.clsLocation = :location AND c.clsIsAmphi = :isamphi AND c.clsShape = :shape AND"
				+ " c.clsHasMicrophone = :hasmicrophone AND c.clsUsage = :usage AND c.clsIsUsed = :isused";
				
		Query q = session.createQuery(hql);
		
		q.setString("type", type);
		q.setInteger("floor", floor);
		q.setString("serialnumber", serialnumber);
		q.setInteger("minClassNum", minClassNum);
		q.setInteger("maxClassNum", maxClassNum);
		q.setInteger("area", area);
		q.setInteger("minExamNum", minExamNum);
		q.setInteger("maxExamNum", maxExamNum);
		q.setString("location", location);
		q.setInteger("isamphi", isamphi);
		q.setString("shape", shape);
		q.setInteger("hasmicrophone", hasmicrophone);
		q.setString("usage", usage);
		q.setInteger("isused", isused);
		
		List<Classroom> list = q.list();
		session.close();
		
		List<Classroom> result = new ArrayList<Classroom>();
		
		for (int i = 0; i < list.size(); i ++) {
			if (list.get(i).getBuilding().getBuildingCompus().equals(compus) &&
					list.get(i).getBuilding().getBuildingDepartment().equals(departmentname) && 
					list.get(i).getBuilding().getBuildingName().equals(buildingname)) {
				result.add(list.get(i));
			}
		}
		
		if (result.size()==0)
			return null;
		else
			return result;
	}
	
	public Classroom find(int clsid) {
		Session session = sessionFactory.openSession();
		
		Classroom c = (Classroom) session.get(Classroom.class, clsid);
		
		session.close();
		
		return c;
	}
	
	public Classroom find(int clsbuildingid, String serialnumber) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Classroom AS c WHERE c.clsBuildingId = :clsbuildingid AND c.clsSerialNumber = :serialnumber";
		Query q = session.createQuery(hql);
		
		q.setInteger("clsbuildingid", clsbuildingid);
		q.setString("serialnumber", serialnumber);
		
		List<Classroom> list = q.list();
		session.close();
		//��ȡbuildingId
		return list.get(0);
	}
	
	//����ѧ¥�����Ƿ�����
	public void add(Classroom classroom) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(classroom);
		tx.commit();
		session.close();
	}
	
	public void update(int clsid, String buildingname, String departmentname,  Classroom classroom) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom c = (Classroom) session.get(Classroom.class, clsid);
		
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
    	c.setClsBuildingId(classroom.getClsBuildingId());
    	
		session.update(c); 
		tx.commit();
		session.close();
	}
	
	public Boolean delete(List<Integer> clsidlst) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (int i = 0; i < clsidlst.size(); i ++) {
			Classroom b = (Classroom) session.get(Classroom.class, clsidlst.get(i));
			//if b == null??
			session.delete(b);
		}
		
		/*
		for (Iterator iter = clsidlst.iterator(); iter.hasNext();) {
			Classroom temp = (Classroom)(iter.next());
			Classroom b = (Classroom) session.get(Classroom.class, temp.getClsId());
			session.delete(b);
		}*/
		
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
