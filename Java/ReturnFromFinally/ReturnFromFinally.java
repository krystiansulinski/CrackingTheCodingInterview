/* 13.2 Return from Finally
 * 
 * In Java, does the finally block get executed if we insert a return statement
 * inside the try block of a try-catch-finally?
 */

/*
 * Yes, it does. The finally block gets executed whenever the try block exits,
 * unless its thread gets killed or the virtual machine exits. It overrides the catch return.
 */

package ReturnFromFinally;

public class ReturnFromFinally {
	public static void main(String[] args) {
		try {
			divide(10, 0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return;
		} finally {
			System.out.println("finally"); // gets executed
		}
	}

	public static int divide(int i, int j) {
		if (j == 0) {
			throw new IllegalArgumentException("Cannot divide by zero.");
		}
		return i / j;
	}
}
