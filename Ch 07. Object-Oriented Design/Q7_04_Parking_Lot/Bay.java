package Q7_04_Parking_Lot;

public class Bay {
	private int level;
	private final int number;
	private boolean available;

	public Bay(int level, int number) {
		this.setLevel(level);
		this.number = number;
	}
	
	public void book() {
		this.setAvailable(false);
	}

	public void unbook() {
		this.setAvailable(true);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumber() {
		return number;
	}
}
