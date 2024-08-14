package parkingLot;

import java.time.LocalDate;

public class Vehicle {

	private String type;
	private String regID;
	private String model;
	private String color;
	private String timeOfEntry;
	private int row, col;
	private LocalDate date;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegID() {
		return regID;
	}

	public void setRegID(String regID) {
		this.regID = regID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTimeOfEntry() {
		return timeOfEntry;
	}

	public void setTimeOfEntry(String timeOfEntry) {
		this.timeOfEntry = timeOfEntry;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Vehicle(String type, String regID, String model, String color, String timeOfEntry, int row, int col,
			LocalDate date) {
		super();
		this.type = type;
		this.regID = regID;
		this.model = model;
		this.color = color;
		this.timeOfEntry = timeOfEntry;
		this.row = row;
		this.col = col;
		this.date = date;
	}

	

}
