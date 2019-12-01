package Stack;

import java.util.EmptyStackException;

public class MyStack<T> {
	private class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;
	private int size;

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		this.size--;
		return item;
	}

	public void push(T item) {
		StackNode<T> t = new StackNode<>(item);
		t.next = top;
		top = t;
		this.size++;
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public boolean empty() {
		return top == null;
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		StackNode<T> t = top;
		String arrow = " -> ";
		
		while (t != null) {
			sb.append(t.data).append(arrow);
			t = t.next;
		}

		sb.delete(sb.length() - arrow.length(), sb.length());
		return sb.toString();
	}
}