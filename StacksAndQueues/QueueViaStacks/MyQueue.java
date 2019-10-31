package QueueViaStacks;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> newest;
	private Stack<T> oldest;
	
	public MyQueue() {
		newest = new Stack<>();
		oldest = new Stack<>();
	}
	
	public void add(T item) {
		newest.add(item);
	}
	
	private void shiftStacks() {
		if (oldest.isEmpty()) {
			while (!newest.isEmpty()) {
				oldest.push(newest.pop());
			}
		}
	}
	
	public T remove() {
		shiftStacks();
		return oldest.pop();
	}
	
	public T peek() {
		shiftStacks();
		return oldest.peek();
	}
	
	public boolean isEmpty() {
		return oldest.size() + newest.size() == 0;
	}
}