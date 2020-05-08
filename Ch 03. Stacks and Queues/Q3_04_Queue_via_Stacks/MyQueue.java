package Q3_04_Queue_via_Stacks;

import java.util.Stack;

public class MyQueue<T> {
    private final Stack<T> newest;
    private final Stack<T> oldest;

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