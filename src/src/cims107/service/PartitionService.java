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
	
	public List<Partition> find(String pyear, String buildingname, String pterm, String serialnumber, 
			String departmentname, String type, int maxavailableseat, int minavailableseat, 
			int maxclassnum, int minclassnum, int maxexamnum, int minexamnum, 
			int beginweek, int endweek, Boolean pisused) {
		
		return partitionDao.find(pyear, buildingname, pterm, serialnumber, 
    			departmentname, type, maxavailableseat, minavailableseat, 
    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
    			beginweek, endweek, pisused);
	}
	
	public void add(Partition partition) {
		partitionDao.add(partition);
	}
	
	public Boolean update(int pid, String pyear, String pterm, int beginweek, int endweek, String pdepartmentname) {
		return partitionDao.update(pid, pyear, pterm, beginweek, endweek, pdepartmentname);
	}
	
}
