package ParkingLot;

import java.util.Set;

public class Level {
	public Set<Bay> bays;
	public int levelNumber;
	public int capacity;
	public int maxHeight;

	Level(int levelNumber, int capacity) {
		this.levelNumber = levelNumber;
		this.capacity = capacity;

		for (int i = 0; i < this.capacity; i++) {
			bays.add(new Bay(this.levelNumber, i));
		}
	}

	public int getAvailableBays() {
		int count = 0;
		for (Bay bay : this.bays) {
			count = count + (bay.isAvailable() == true ? 1 : 0);
		}
		return count;
	}
	
	public boolean hasAvailableBays() {
		for (Bay bay : this.bays) {
			if (bay.isAvailable()) {
				return true;
			}
		}
		return false;
	}
}
