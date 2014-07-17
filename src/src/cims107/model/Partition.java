package cims107.model;

import java.sql.Date;

public class Partition {
	private int pId;
	private String pYear;
	private String pTerm;
	private int pClsId;
	private String pDepartment;
	private int pClassNum;
	private int pExamNum;
	private int pBeginWeek;
	private int pEndWeek;
	private Date pBeginDate;
	private Date pEndDate;
	private int pBeginLession;
	private int pEndLession;
	private String pWhichDay;
	private int pIsUsed;
	
	public String getpWhichDay() {
		return pWhichDay;
	}
	public void setpWhichDay(String pWhichDay) {
		this.pWhichDay = pWhichDay;
	}
	public Date getpBeginDate() {
		return pBeginDate;
	}
	public void setpBeginDate(Date pBeginDate) {
		this.pBeginDate = pBeginDate;
	}
	public Date getpEndDate() {
		return pEndDate;
	}
	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}
	public int getpBeginLession() {
		return pBeginLession;
	}
	public void setpBeginLession(int pBeginLession) {
		this.pBeginLession = pBeginLession;
	}
	public int getpEndLession() {
		return pEndLession;
	}
	public void setpEndLession(int pEndLession) {
		this.pEndLession = pEndLession;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpYear() {
		return pYear;
	}
	public void setpYear(String pYear) {
		this.pYear = pYear;
	}
	public String getpTerm() {
		return pTerm;
	}
	public void setpTerm(String pTerm) {
		this.pTerm = pTerm;
	}
	public int getpClsId() {
		return pClsId;
	}
	public void setpClsId(int pClsId) {
		this.pClsId = pClsId;
	}
	public String getpDepartment() {
		return pDepartment;
	}
	public void setpDepartment(String pDepartment) {
		this.pDepartment = pDepartment;
	}
	public int getpClassNum() {
		return pClassNum;
	}
	public void setpClassNum(int pClassNum) {
		this.pClassNum = pClassNum;
	}
	public int getpExamNum() {
		return pExamNum;
	}
	public void setpExamNum(int pExamNum) {
		this.pExamNum = pExamNum;
	}
	public int getpBeginWeek() {
		return pBeginWeek;
	}
	public void setpBeginWeek(int pBeginWeek) {
		this.pBeginWeek = pBeginWeek;
	}
	public int getpEndWeek() {
		return pEndWeek;
	}
	public void setpEndWeek(int pEndWeek) {
		this.pEndWeek = pEndWeek;
	}
	public int getpIsUsed() {
		return pIsUsed;
	}
	public void setpIsUsed(int pIsUsed) {
		this.pIsUsed = pIsUsed;
	}
	
	
}
