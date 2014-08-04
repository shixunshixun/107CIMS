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
import cims107.model.Seat;

public class SeatManageDao {
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(SeatManageDao.class);

	public Seat find(int row, int col, int clsid) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Seat AS s WHERE s.seatRow = :row AND s.seatCol = :col AND s.seatClsId = :clsid";
		Query q = session.createQuery(hql);
		
		q.setInteger("row", row);
		q.setInteger("col", col);
		q.setInteger("clsid", clsid);
		
		List<Seat> list = q.list();
		session.close();
		//��ȡbuildingId
		// in case find nothing
		if (list.size()==0)
			return null;
		else
			return list.get(0);
	}
	
	public void updateSeatState(Seat s, Boolean state) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();		
			
			Seat mys = (Seat) session.get(Seat.class, s.getSeatClsId());
			
			mys.setSeatProperty(state);
			session.update(mys);
			
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" update seat table of classroom " + s.getSeatClsId());
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
	public void add(int clsid, int maxrow, int maxcol) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			
			for (int i = 1; i <= maxrow; i ++) {
				for (int j = 1; j <= maxcol; j ++) {
					Seat s = new Seat();
					s.setSeatClsId(clsid);
					s.setSeatRow(i);
					s.setSeatCol(i);
					s.setSeatProperty(true);
					
					session.save(s);
				}
			}
			
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" create seattable of classroom  " + clsid);
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
	
	public void delete(int clsid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			tx = session.beginTransaction();
			//Partition p = (Partition) session.get(Partition.class, partitionlst.get(i));
			Seat s = (Seat) session.get(Seat.class, clsid);
			session.delete(s);
	
			tx.commit();
			log.info(ActionContext.getContext().getSession().get("username").toString() + 
					" delete seat information of classroom of (" + clsid + ")");
		}
		catch(Exception e) {
			if(tx != null)	tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
