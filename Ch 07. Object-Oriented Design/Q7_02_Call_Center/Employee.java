package Q7_02_Call_Center;

public class Employee {
    public String firstName;
    public String lastName;
    public boolean isAvailable;

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAvailable = true;
    }

    public void answer(Caller caller) throws InterruptedException {
        this.isAvailable = false;
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
        this.isAvailable = true;
    }

	public boolean isAvailable() {
		return isAvailable;
	}
}
