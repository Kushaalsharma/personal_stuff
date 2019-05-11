package treesAndGraphs.dfs;

import java.io.ObjectInputStream.GetField;

import treesAndGraphs.Node;

public class _0_PreOrderRecursion {

	public static void main(String[] args) {
		System.out.println("Preorder :::  root, left and then right");
		Node<Integer> root = Node.getBasicTree();
		preOrderRecursion(root);
		
	}

	public static void preOrderRecursion(Node<Integer> node) {
		// base condition
		if (node == null)
			return;
		System.out.print(" " + node.data + "");
		preOrderRecursion(node.left);
		preOrderRecursion(node.right);
	}
	

}
