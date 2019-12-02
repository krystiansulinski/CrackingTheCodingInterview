package Stack;

import java.util.EmptyStackException;

public class MyStack<T> {
	public class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
		
		public String toString() {
			return data.toString();
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

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return this.size;
	}
	
	public void sort() {
		MyStack<T> tmp = new MyStack<>();
		while (this.size() != 0) {
			tmp.push(this.popMin());
		}
		
		while (tmp.size() != 0) {
			this.push(tmp.pop());
		}
	}

	public T popMin() {
		if (this.size() == 1) {
			return this.pop();
		}
		
		T min = getMin();
		if (this.peek() == min) {
			return this.pop();
		}
		StackNode<T> previous = top;
		StackNode<T> current = previous.next;
		while (min != current.data) {
			previous = current;
			current = current.next;
		}
		
		previous.next = current.next;
		this.size--;
		return min;
	}

	private T getMin() {
		StackNode<T> p = top;
		T min = p.data;

		for (int i = 1; i < this.size(); i++) {
			p = p.next;
			if ((Integer) p.data < (Integer) min) {
				min = p.data;
			}
		}
		return min;
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