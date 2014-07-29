package cims107.dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
		DetachedCriteria dc = DetachedCriteria.forClass(Classroom.class);
		
		if (!type.isEmpty()) {
			dc.add(Restrictions.eq("clsType",type));
		}
		if (floor > 0) {
			dc.add(Restrictions.eq("clsFloor",floor));
		}
		if (!serialnumber.isEmpty()) {
			dc.add(Restrictions.eq("clsSerialNumber",serialnumber));
		}
		if (area > 0) {
			dc.add(Restrictions.eq("clsArea",area));
		}
		if (!location.isEmpty()) {
			dc.add(Restrictions.eq("clsLocation",location));
		}
		if (isamphi == 2 || isamphi == 1) {
			dc.add(Restrictions.eq("clsIsAmphi",isamphi));
		}
		if (!shape.isEmpty()) {
			dc.add(Restrictions.eq("clsShape",shape));
		}
		if (hasmicrophone == 2 || hasmicrophone == 1) {
			dc.add(Restrictions.eq("clsHasMicrophone",hasmicrophone));
		}
		if (!usage.isEmpty()) {
			dc.add(Restrictions.eq("clsUsage",usage));
		}
		if (isused == 2 || isused == 1) {
			dc.add(Restrictions.eq("clsIsUsed",isused));
		}
		if (maxClassNum != 0) {
			if (minClassNum != 0)
				dc.add(Restrictions.between("clsClassNum", minClassNum, maxClassNum));
			else
				dc.add(Restrictions.le("clsClassNum", new Integer(maxClassNum)));
		}
		if (maxClassNum == 0) {
			if (minClassNum != 0)
				dc.add(Restrictions.ge("clsClassNum", new Integer(minClassNum)));
		}
		if (maxExamNum != 0) {
			if (minExamNum != 0)
				dc.add(Restrictions.between("clsExamNum", minExamNum, maxExamNum));
			else
				dc.add(Restrictions.le("clsExamNum", new Integer(maxExamNum)));
		}
		if (maxExamNum == 0) {
			if (minExamNum != 0)
				dc.add(Restrictions.ge("clsExamNum", new Integer(minExamNum)));
		}
		
		Criteria c = dc.getExecutableCriteria(session);
		
		List<Classroom> list = c.list();
		Iterator<Classroom> iter = list.iterator();
		
		//Hibernate.initialize();
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
		Transaction tx = session.beginTransaction();
		session.save(classroom);
		tx.commit();
		session.close();
	}
	
	public void update(Classroom classroom) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
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
