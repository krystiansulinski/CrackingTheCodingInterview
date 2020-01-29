package ParkingLot;

public class Gate {
	public void notifyNoAvailableSpots() {
		System.out.println("No available spots.");
	}

	public void notifyCarIsBanned(String registration) {
		System.out.println("We are sorry, you cannot park here.");
		System.out.println("The car " + registration + " has been banned from this parking lot.");		
	}

	public void open() {
		// TODO Auto-generated method stub
		
	}

	public void issuePayment(double payment) {
		System.out.println("Please pay " + payment + ".");
	}
}
