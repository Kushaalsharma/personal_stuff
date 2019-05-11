package treesAndGraphs.dfs;

import java.util.Stack;

import treesAndGraphs.Node;

public class _1_InOrderNonRecursive {
	public static void main(String[] args) {
		Node root = Node.getBasicTree();
		System.out.println("Preorder :::  root, left and then right");
		inOrderNonRecursive(root);
	}

	public static void inOrderNonRecursive(Node<Integer> node) {
		if (node == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		Node current = node;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				// traverse the left side of the node
				stack.push(current);
				current = current.left;
			}
			// if no node at left, then pop the element from stack, print it and look for
			// right subtree
			current = stack.pop();
			System.out.print(" " + current.data + " , ");
			current = current.right;
		}
	}
}
