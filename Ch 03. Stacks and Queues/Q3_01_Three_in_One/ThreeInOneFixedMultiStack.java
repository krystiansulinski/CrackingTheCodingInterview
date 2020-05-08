package Q3_01_Three_in_One;

import java.util.EmptyStackException;

public class ThreeInOneFixedMultiStack {
    private final StackInfo[] info;
    private final int[] values;

    public ThreeInOneFixedMultiStack(int numberOfStacks, int defaultSize) {
        info = new StackInfo[numberOfStacks];

        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(i * defaultSize, defaultSize);
        }

        values = new int[numberOfStacks * defaultSize];
    }

    private class StackInfo {
        public int start;
        public int size;
        public int capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

		public boolean isWithinStackCapacity(int index) {
			if (index < 0 || index >= values.length) {
				return false;
			}

            int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
	
	public int pop(int stackNum) {
		StackInfo stack = info[stackNum];
		if (info[stackNum].isEmpty()) {
			throw new EmptyStackException();
		}
		int value = values[stack.lastCapacityIndex()];
		stack.size--;
		return value;
	}
	
	public int peek(int stackNum) {
		StackInfo stack = info[stackNum];
		return values[stack.lastCapacityIndex()];
	}
	
	public void push(int stackNum, int value) throws FullStackException {
		if (allStacksAreFull()) {
			throw new FullStackException();
		}
		
		StackInfo stack = info[stackNum];
		if (stack.isFull()) {
			expand(stackNum);
		}
		
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}
	
	// -11 % 5 = -1, ((-11 % 5) + 5) % 5 = 1
	private int adjustIndex(int index) {
		int max = values.length;
		return ((index % max) + max) % max;
	}
	
	public void shift(int stackNum) {
		StackInfo stack = info[stackNum];
		
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			stack.capacity++;
		}
		
		int index = stack.lastCapacityIndex();
		while (stack.isWithinStackCapacity(index)) {
			values[index] = values[previousIndex(index)];
			values[stack.start] = 0;
			stack.start = nextIndex(stack.start);
			stack.capacity--;
		}
	}
	
	public void expand(int stackNum) {
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;
	}
	
	public boolean allStacksAreFull() {
		return numberOfElements() == values.length;
	}
	
	public int numberOfElements() {
		int size = 0;
		for (StackInfo s : info) {
			size += s.size;
		}
		return size;
	}
	
	public int nextIndex(int index) {
		return adjustIndex(index + 1);
	}
	
	public int previousIndex(int index) {
		return adjustIndex(index - 1);
	}
}
