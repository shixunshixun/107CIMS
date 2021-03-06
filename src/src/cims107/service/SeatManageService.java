package cims107.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cims107.dao.ClassroomDao;
import cims107.dao.SeatManageDao;
import cims107.model.Classroom;
import cims107.model.Seat;

public class SeatManageService {
	private SeatManageDao seatmanageDao;

	public SeatManageDao getSeatmanageDao() {
		return seatmanageDao;
	}

	public void setSeatmanageDao(SeatManageDao seatmanageDao) {
		this.seatmanageDao = seatmanageDao;
	}

	public Seat find(int row, int col, int clsid) {
		return seatmanageDao.find(row, col, clsid);
	}
	
	public List<Seat> find(int clsid) {
		return seatmanageDao.find(clsid);
	}
	
	public void updateSeatState(Seat s, Boolean state) {
		seatmanageDao.updateSeatState(s, state);
	}
    
    public void add(Classroom cls, int maxrow, int maxcol) {
    	if (maxrow != 0 && maxcol != 0)
    		seatmanageDao.add(cls, maxrow, maxcol);
    	else
    		seatmanageDao.add(cls, 8, 8);
    }
    public void delete(int clsid) {
    	seatmanageDao.delete(clsid);
    }
}
