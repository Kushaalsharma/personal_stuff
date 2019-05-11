package treesAndGraphs.tree.dfs;

import treesAndGraphs.tree.Node;

public class _0_InOrderRecursion {

	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n In order  :::  left ,root, then right\n\n");
		inOrderRecursion(root);
	}

	public static void inOrderRecursion(Node<Integer> node) {
		// base condition
		if (node == null)
			return;
		inOrderRecursion(node.left);
		System.out.print(" " + node.data + " ,");
		inOrderRecursion(node.right);
	}
	

}
