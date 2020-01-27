package CallCenter;

public class Employee {
	public String firstName;
	public String lastName;
	public boolean isAvailable;

	Employee(String firstName, String lastName, boolean isAvailable) {
		this.firstName = firstName;
		this.lastName = lastName;
		isAvailable = true;
	}

	public void answer(Caller caller) throws InterruptedException {
		isAvailable = false;
		caller.connects();
		monitorCall(caller);
		endCall();
	}

	public void monitorCall(Caller caller) throws InterruptedException {
		while (caller.isTalking()) {
			Thread.sleep(1000);
		}
		caller.disconnects();
	}

	public void endCall() {
		isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
}
