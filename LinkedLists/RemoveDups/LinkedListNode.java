package RemoveDups;


public class LinkedListNode {
	public int value;
	public LinkedListNode next;

	LinkedListNode(int value) {
		this.value = value;
	}
	
	public LinkedListNode(int[] values) {
		this.value = values[0];
		int[] rest = new int[values.length - 1];
		System.arraycopy(values, 1, rest, 0, rest.length);
		this.appendToTail(rest);
	}

	public void appendToTail(int[] values) {
		LinkedListNode node = this;

		for (int i : values) {
			node.appendToTail(i);
			node = node.next;
		}
	}

	public void appendToTail(int value) {
		LinkedListNode end = new LinkedListNode(value);
		LinkedListNode node = this;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}

	@Override
	public String toString() {
		String s = "";
		LinkedListNode node = this;
		
		while (node != null) {
			s += node.value + " -> ";
			node = node.next;
		}
		return s.substring(0, s.length() - 4);
	}
}
