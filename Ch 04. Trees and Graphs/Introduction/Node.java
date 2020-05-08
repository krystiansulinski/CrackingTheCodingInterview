package Introduction;

public class Node {
	public int name;
	public boolean visited;
	public Node[] children;

	public Node(int name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n[" + name + ", " + visited + ", " + children.length + "]";
	}
}