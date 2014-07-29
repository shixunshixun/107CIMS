package cims107.service;

import java.util.*;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cims107.dao.PartitionDao;
import cims107.model.Partition;

public class PartitionService {
	private PartitionDao partitionDao;

	public PartitionDao getPartitionDao() {
		return partitionDao;
	}

	public void setPartitionDao(PartitionDao partitionDao) {
		this.partitionDao = partitionDao;
	}
	
	public List<Partition> find() {
		return partitionDao.find();
	}
	
	public List<Partition> find(String pyear, String compus, String buildingname, String pterm, String serialnumber, 
			String departmentname, String type, int maxavailableseat, int minavailableseat, 
			int maxclassnum, int minclassnum, int maxexamnum, int minexamnum, 
			int beginweek, int endweek, int pisused) {
		
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
		
		return partitionDao.find(compus, buildingname, serialnumber, type, maxavailableseat, minavailableseat, dc);
	}
	
	public void add(Partition partition) {
		partitionDao.add(partition);
	}
	
	public Boolean update(Partition partition) {
		return partitionDao.update(partition);
	}
	
	public void enabeUpdate(List<Integer> partitionlst) {
		partitionDao.enabeUpdate(partitionlst);
	}
	
	public void disableUpdate(List<Integer> partitionlst) {
		partitionDao.disableUpdate(partitionlst);
	}
	
	public Boolean delete(List<Integer> partitionlst) {
		return partitionDao.delete(partitionlst);
	}
	
}
