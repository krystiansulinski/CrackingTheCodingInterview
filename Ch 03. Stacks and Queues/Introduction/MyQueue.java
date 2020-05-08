package Introduction;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private final T data;
        private QueueNode<T> next;

        QueueNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item) {
		QueueNode<T> node = new QueueNode<>(item);
		
		if (last != null) {
			last.next = node;
		}
		
		last = node;
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		
		return data;
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
