package cims107.action;

import net.sf.json.JSONObject;
import cims107.model.Classroom;
import cims107.model.Seat;
import cims107.service.ClassroomService;
import cims107.service.SeatManageService;

import com.opensymphony.xwork2.ActionSupport;

public class SeatManageAction extends ActionSupport{
	public int clsid;
	public int seatNum;
	public Boolean state;
	private JSONObject result;
	
	private ClassroomService classroomService;
	private SeatManageService seatmanageService;
	
	public SeatManageAction() 
    {  
        System.out.println("initialize ClassroomCreateAction......");  
    }
	public ClassroomService getClassroomService() {
		return classroomService;
	}

	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}
	public SeatManageService getSeatmanageService() {
		return seatmanageService;
	}
	public void setSeatmanageService(SeatManageService seatmanageService) {
		this.seatmanageService = seatmanageService;
	}

	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	public int getClsid() {
		return clsid;
	}

	public void setClsid(int clsid) {
		this.clsid = clsid;
	}
	
	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String execute() {
		int row, col;
		
		Classroom c = new Classroom();
		c = classroomService.find(clsid);
		
		//根据seatnum来获取座位位置
		if (seatNum % c.getClsMaxCol() == 0)
			row = seatNum / c.getClsMaxCol();
		else
			row = seatNum / c.getClsMaxCol() + 1;
		
		col = seatNum - (row-1) * c.getClsMaxCol();
		
		Seat s = new Seat();
		
		s = seatmanageService.find(row, col, clsid);
		seatmanageService.updateSeatState(s, state);
		
		result = JSONObject.fromObject("{\"success\":1}");
		
		return SUCCESS;
	}
}
