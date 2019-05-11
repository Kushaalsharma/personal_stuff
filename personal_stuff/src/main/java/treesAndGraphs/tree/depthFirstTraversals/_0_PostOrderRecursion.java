package treesAndGraphs.tree.depthFirstTraversals;

import treesAndGraphs.tree.Node;

public class _0_PostOrderRecursion {

	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n post order  :::  left right and then root\n\n");
		postOrderRecursion(root);
	}

	public static void postOrderRecursion(Node<Integer> node) {
		// base condition
		if (node == null)
			return;
		postOrderRecursion(node.left);
		postOrderRecursion(node.right);
		System.out.print(" " + node.data + " ,");
	}
	

}
