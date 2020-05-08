package Q3_02_Stack_Min;

import java.util.Stack;

public class StackMin extends Stack<Integer> { 
	Stack<Integer> mins;
	
	public StackMin() {
		mins = new Stack<>();
	}
	
	public void push(int value) {
		if (value < min()){
			mins.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			mins.pop();
		}
		return value;
	}
	
	public int min() {
		if (mins.empty()) {
			return Integer.MAX_VALUE;
		}
		return mins.peek();
	}
}

