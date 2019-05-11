package treesAndGraphs.tree.boundryTraversals;

import treesAndGraphs.tree.Node;

public class _0_leaf_view {
	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n leaf view of the Tree is :: \n\n");
		leaf_view(root);

	}

	public static void leaf_view(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			System.out.print(" " + node.data + ", ");
		leaf_view(node.left);
		leaf_view(node.right);
	}

}
