package cims107.action;

import com.opensymphony.xwork2.ActionSupport;

import cims107.model.Partition;

public class PartitionCreateAction extends ActionSupport{
	public String pyear;
	public String buildingname;
	public String pterm;
	public String serialnumber;
	public String departmentname;
	public String type;
	public int maxavailableseat;
	public int minavailableseat;
	public int maxclassnum;
	public int minclassnum;
	public int maxexamnum;
	public int minexamnum;
	public String beginweek;
	public String endweek;
	
	public String compus;
	public int floor;
	public String type;
	public String shape;
	public int classnum;
	public int examnum;
	public int maxrow;
	public int maxcol;
	public String hcorridorlocate;
	public String vcorridorlocate;
	public int area;
	public String location;
	public Boolean isamphi;
	public Boolean hasmicrophone;
	public Boolean isused;
	public String usage;
	public int seatnum;
	public int availableseatnum;
}
