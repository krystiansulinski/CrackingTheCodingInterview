package Introduction;

import java.util.EmptyStackException;

public class MyStack<Integer> {
	private StackNode<Integer> top;

	private Integer getMin() {
		StackNode<Integer> p = top;
		Integer min = p.data;

		for (int i = 1; i < this.size(); i++) {
			p = p.next;
			if ((int) p.data < (int) min) {
				min = p.data;
			}
		}
		return min;
	}

	private int size;

	public Integer pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		Integer item = top.data;
		top = top.next;
		this.size--;
		return item;
	}

	public void push(Integer item) {
		StackNode<Integer> t = new StackNode<>(item);
		t.next = top;
		top = t;
		this.size++;
	}

	public Integer peek() {
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
		MyStack<Integer> tmp = new MyStack<>();
		while (this.size() != 0) {
			tmp.push(this.popMin());
		}

		while (tmp.size() != 0) {
			this.push(tmp.pop());
		}
	}

	public Integer popMin() {
		if (this.size() == 1) {
			return this.pop();
		}

		Integer min = getMin();
		if (this.peek() == min) {
			return this.pop();
		}
		StackNode<Integer> previous = top;
		StackNode<Integer> current = previous.next;
		while (min != current.data) {
			previous = current;
			current = current.next;
		}

		previous.next = current.next;
		this.size--;
		return min;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		StackNode<Integer> t = top;
		String arrow = " -> ";

		while (t != null) {
			sb.append(t.data).append(arrow);
			t = t.next;
		}

		sb.delete(sb.length() - arrow.length(), sb.length());
		return sb.toString();
	}

	public class StackNode<Integer> {
		private final Integer data;
		private StackNode<Integer> next;

		public StackNode(Integer data) {
			this.data = data;
		}

		public String toString() {
			return data.toString();
		}
	}
}