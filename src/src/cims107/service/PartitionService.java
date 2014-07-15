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
			String beginweek, String endweek, Boolean pisused) {
		
		return partitionDao.find(pyear, buildingname, pterm, serialnumber, 
    			departmentname, type, maxavailableseat, minavailableseat, 
    			maxclassnum, minclassnum, maxexamnum, minexamnum, 
    			beginweek, endweek, pisused);
	}
	
}
