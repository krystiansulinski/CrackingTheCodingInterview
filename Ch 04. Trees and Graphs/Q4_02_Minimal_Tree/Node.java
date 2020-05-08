package Q4_02_Minimal_Tree;

public class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}
	
	public Node insert(int i) {
		Node node = new Node(i);
		
		if (i < node.value) {
			node.left = insert(i);
		} else {
			node.right = insert(i);
		}
		
		return node;
	}

	@Override
	public String toString() {
		return value + "";
	} 
}
