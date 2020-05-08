package Q2_04_Partition;

import Introduction.LinkedListNode;
import org.junit.Test;

public class PartitionTest {
	@Test
	public void partitionTest() {
		int[][] nodes = { { 3, 5, 8, 5, 10, 2, 1 }, { 1, 10, 2, 9, 3, 8, 4, 9 }, { 5, 6, 7, 1, 8 }, {6, 4}};
		for (int[] n : nodes) {
			print(n);
		}
	}

	private void print(int[] values) {
		LinkedListNode node = new LinkedListNode(values);

		System.out.println("\n" + node);
		Partition.partition(node, 5);
		System.out.println(node);
	}
}
