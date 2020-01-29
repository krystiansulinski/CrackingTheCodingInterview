/*
 * 7.4 Parking Lot
 * 
 * Design a parking lot using object-oriented principles.
 */

package ParkingLot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Assumptions:
 * - multilevel
 * - paid
 * - passenger cars only
 * - two gates in, two gates out
 * - open 24/7
 * - online booking available
 * - privately owned
 * - in a separate building
 * - located in the city center
 * - two janitors at the site
 * - bay sensors to detect cars
 * - flat fee

 * Components: Parking Lot, Level, Bay, Gate, Car, Transactions
 */

public class ParkingLot {
	Set<Level> levels;
	Map<String, Car> cars;
	List<Gate> gates;
	private int maxCapacity;
	Transactions transactions;

	ParkingLot(Map<Integer, Integer> bays, int gates) {
		createBays(bays);
		calculateCapacity(bays.values());
		createGates(gates);
		this.cars = new HashMap<>();
		transactions = new Transactions();
	}

	public void createBays(Map<Integer, Integer> levels) {
		this.levels = new HashSet<>();
		for (int level : levels.keySet()) {
			this.levels.add(new Level(level, levels.get(level)));
		}
	}

	public void calculateCapacity(Collection<Integer> collection) {
		int capacity = 0;
		for (int bay : collection) {
			capacity += bay;
		}
		this.setMaxCapacity(capacity);
	}

	public void createGates(int gates) {
		this.gates = new ArrayList<>(gates);
	}

	public void carEnters(String registration, int gateNumber) {
		Date enteredTime = new Date();
		Car car = cars.get(registration);
		Gate gate = gates.get(gateNumber);

		if (car == null) {
			car = new Car(registration, enteredTime);
		} else if (car.isBanned()) {
			gate.notifyCarIsBanned(registration);
		}

		if (hasAvailableBays()) {
			cars.put(registration, new Car(registration, enteredTime));
			gate.open();
		} else {
			gate.notifyNoAvailableSpots();
		}
	}

	public void carLeaves(String registration, int gateNumber) {
		Car car = cars.get(registration);
		Gate gate = gates.get(gateNumber);
		Date leftTime = new Date();
		gate.issuePayment(transactions.calculatePayment(car, leftTime));
	}

	public boolean hasAvailableBays() {
		for (Level level : levels) {
			if (level.hasAvailableBays()) {
				return true;
			}
		}
		return false;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
