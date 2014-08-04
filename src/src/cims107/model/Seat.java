package cims107.model;

public class Seat {
	private int seatClsId;
	private int seatRow;
	private int seatCol;
	private boolean seatProperty;
	private Classroom classroom;
	public int getSeatClsId() {
		return seatClsId;
	}
	public void setSeatClsId(int seatClsId) {
		this.seatClsId = seatClsId;
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatCol() {
		return seatCol;
	}
	public void setSeatCol(int seatCol) {
		this.seatCol = seatCol;
	}
	public boolean isSeatProperty() {
		return seatProperty;
	}
	public void setSeatProperty(boolean seatProperty) {
		this.seatProperty = seatProperty;
	}
}
