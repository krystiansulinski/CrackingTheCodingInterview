package StackOfPlates;

import java.util.ArrayList;
import java.util.List;

import Stack.MyStack;

public class StackOfPlates<T> {
	private List<MyStack<T>> stacks;
	private int threshold;

	StackOfPlates(int threshold) {
		stacks = new ArrayList<>(); 
		this.threshold = threshold;
	}

	public void push(T item) {
		for (MyStack<T> stack : this.stacks) {
			if (stack.size() < threshold) {
				stack.push(item);
				return;
			}
		}
		MyStack<T> stack = new MyStack<T>();
		stack.push(item);
		stacks.add(stack);
	}
	
	public T pop() {
		int lastStack = Math.max(this.stacks.size() - 1, 0);
		MyStack<T> stack = this.stacks.get(lastStack);
		T top = stack.pop();
		if (stack.size() == 0) {
			 this.stacks.remove(lastStack);
		}
		return top;
	}
}
