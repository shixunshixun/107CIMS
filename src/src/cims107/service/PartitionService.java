package cims107.service;

import java.util.*;

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
		
		return partitionDao.find(pyear, compus, buildingname, pterm, serialnumber, 
    			departmentname, type, maxavailableseat, minavailableseat, 
    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
    			beginweek, endweek, pisused);
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
