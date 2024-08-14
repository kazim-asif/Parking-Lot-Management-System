package parkingLot;

import java.time.LocalDate;

public class Ledger {

	private Vehicle v;
	private int hitCount;
	private double amount;
	private String exitTime;
	private LocalDate date;

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Ledger [v=" + v + ", hitCount=" + hitCount + ", amount=" + amount + ", exitTime=" + exitTime + ", date="
				+ date + "]";
	}

	public Ledger(Vehicle v, int hitCount, double amount, String exitTime, LocalDate date) {
		super();
		this.v = v;
		this.hitCount = hitCount;
		this.amount = amount;
		this.exitTime = exitTime;
		this.date = date;
	}

}
