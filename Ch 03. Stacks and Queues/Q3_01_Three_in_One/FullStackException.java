package Q3_01_Three_in_One;

public class FullStackException extends RuntimeException {
	private static final long serialVersionUID = 7414432888898968469L;

	public FullStackException() {
		this("Stack is full.");
	}
	
	public FullStackException(String exception) {
		super(exception);
	}
}
