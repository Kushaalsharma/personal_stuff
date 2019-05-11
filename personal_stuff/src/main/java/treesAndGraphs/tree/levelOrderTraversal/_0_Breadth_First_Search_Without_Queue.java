package treesAndGraphs.tree.levelOrderTraversal;

import treesAndGraphs.tree.Node;

public class _0_Breadth_First_Search_Without_Queue {
	public static void main(String[] args) {
		Node root = Node.getBasicTree();
		System.out.println("\nBreadth first traversal using queue ::\n");
		bfs_without_queue(root);
	}

	public static void bfs_without_queue(Node<Integer> root) {
		int height = Node.height(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}

	}

	public static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(" " + root.data + ", ");
		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}
}
