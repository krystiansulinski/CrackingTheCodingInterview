package Q7_04_Parking_Lot;

import java.util.Date;

public class Transactions {
	int feePerHour = 4;

	public double calculatePayment(Car car, Date leftTime) {
		return (leftTime.getTime() - car.getEnteredTime().getTime()) * 1000 * feePerHour;
	}
}
