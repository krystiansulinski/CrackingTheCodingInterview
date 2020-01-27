package CallCenter;

public class Caller {
	private String ID;
	private boolean isWaiting;
	private boolean isTalking;

	public void connects() {
		isTalking = true;
	}
	
	public boolean isTalking() {
		return isTalking;
	}

	public void disconnects() {
		isTalking = false;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}
}
