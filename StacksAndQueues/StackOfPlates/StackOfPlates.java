/*
 * 3.3 Stack of Plates
 * 
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * 
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

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

	public T popAt(int index) {
		T top = popItAt(index - 1);
		shiftLeft(index - 1);
		return top;
	}

	private T popItAt(int index) {
		if (index < 0) {
			return null;
		}
		MyStack<T> stack = this.stacks.get(index);
		T top = stack.pop();
		if (stack.size() == 0) {
			this.stacks.remove(stack);
		}

		return top;
	}

	private void shiftLeft(int index) {
		int i = index + 1;
		
		while (this.stacks.size() > i) {
			MyStack<T> previous = this.stacks.get(i - 1);
			MyStack<T> stack = this.stacks.get(i);
			
			previous.push(stack.pop());
			if (stack.size() == 0) {
				this.stacks.remove(stack);
			}
			i++;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		for (MyStack<T> stack : this.stacks) {
			sb.append("Stack ").append(i + 1).append(": ").append(stack.toString()).append("\n");
			i++;
		}

		return sb.toString();
	}
}
