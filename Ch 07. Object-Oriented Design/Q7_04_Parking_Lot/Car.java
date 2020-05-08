package Q7_04_Parking_Lot;

import java.util.Date;

public class Car {
	private String registration;
	private Date enteredTime;
	private boolean isBanned;

	Car(String registration, Date date) {
		this.setRegistration(registration);
		this.setEnteredTime(date);
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public Date getEnteredTime() {
		return enteredTime;
	}

	public void setEnteredTime(Date enteredTime) {
		this.enteredTime = enteredTime;
	}
}
