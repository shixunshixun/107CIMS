package cims107.model;

public class Seat {
	private int seatId;
	private int seatRow;
	private int seatCol;
	private boolean seatProperty;
	private Classroom classroom;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
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
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public boolean isSeatProperty() {
		return seatProperty;
	}
	public void setSeatProperty(boolean seatProperty) {
		this.seatProperty = seatProperty;
	}
}
