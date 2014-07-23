package cims107.model;

import java.sql.Date;

public class Partition {
	private int partitionId;
	private String partitionYear;
	private String partitionTerm;
	//private int partitionClsId;
	private String partitionDepartment;
	private int partitionClassNum;
	private int partitionExamNum;
	private int partitionBeginWeek;
	private int partitionEndWeek;
	private String partitionBeginDate;
	private String partitionEndDate;
	private int partitionBeginLession;
	private int partitionEndLession;
	private String partitionWhichDay;
	private int partitionIsUsed;
	private Classroom classroom;
	
	public int getPartitionId() {
		return partitionId;
	}
	public void setPartitionId(int partitionId) {
		this.partitionId = partitionId;
	}
	public String getPartitionYear() {
		return partitionYear;
	}
	public void setPartitionYear(String partitionYear) {
		this.partitionYear = partitionYear;
	}
	public String getPartitionTerm() {
		return partitionTerm;
	}
	public void setPartitionTerm(String partitionTerm) {
		this.partitionTerm = partitionTerm;
	}
	/*public int getPartitionClsId() {
		return partitionClsId;
	}
	public void setPartitionClsId(int partitionClsId) {
		this.partitionClsId = partitionClsId;
	}*/
	public String getPartitionDepartment() {
		return partitionDepartment;
	}
	public void setPartitionDepartment(String partitionDepartment) {
		this.partitionDepartment = partitionDepartment;
	}
	public int getPartitionClassNum() {
		return partitionClassNum;
	}
	public void setPartitionClassNum(int partitionClassNum) {
		this.partitionClassNum = partitionClassNum;
	}
	public int getPartitionExamNum() {
		return partitionExamNum;
	}
	public void setPartitionExamNum(int partitionExamNum) {
		this.partitionExamNum = partitionExamNum;
	}
	public int getPartitionBeginWeek() {
		return partitionBeginWeek;
	}
	public void setPartitionBeginWeek(int partitionBeginWeek) {
		this.partitionBeginWeek = partitionBeginWeek;
	}
	public int getPartitionEndWeek() {
		return partitionEndWeek;
	}
	public void setPartitionEndWeek(int partitionEndWeek) {
		this.partitionEndWeek = partitionEndWeek;
	}
	public String getPartitionBeginDate() {
		return partitionBeginDate;
	}
	public void setPartitionBeginDate(String partitionBeginDate) {
		this.partitionBeginDate = partitionBeginDate;
	}
	public String getPartitionEndDate() {
		return partitionEndDate;
	}
	public void setPartitionEndDate(String partitionEndDate) {
		this.partitionEndDate = partitionEndDate;
	}
	public int getPartitionBeginLession() {
		return partitionBeginLession;
	}
	public void setPartitionBeginLession(int partitionBeginLession) {
		this.partitionBeginLession = partitionBeginLession;
	}
	public int getPartitionEndLession() {
		return partitionEndLession;
	}
	public void setPartitionEndLession(int partitionEndLession) {
		this.partitionEndLession = partitionEndLession;
	}
	public String getPartitionWhichDay() {
		return partitionWhichDay;
	}
	public void setPartitionWhichDay(String partitionWhichDay) {
		this.partitionWhichDay = partitionWhichDay;
	}
	public int getPartitionIsUsed() {
		return partitionIsUsed;
	}
	public void setPartitionIsUsed(int partitionIsUsed) {
		this.partitionIsUsed = partitionIsUsed;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	
	
}
