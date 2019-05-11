package treesAndGraphs.dfs;

import java.util.Stack;

import treesAndGraphs.Node;

public class _1_PostOrderNonRecursiveTwoStack {
	public static void main(String[] args) {
		Node root = Node.getBasicTree();
		/*
		 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
		 */
		System.out.println("postOrder :::  left ,right and then root");
		postOrderNonRecursive(root);
	}

	public static void postOrderNonRecursive(Node<Integer> root) {
		if (root == null)
			return;

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

		stack1.push(root);

		while (!stack1.isEmpty()) {
			Node current = stack1.pop();
			stack2.push(current);
			if (current.left != null)
				stack1.push(current.left);
			if (current.right != null)
				stack1.push(current.right);
		}

		// print the content of 2nd stack
		while (!stack2.isEmpty()) {
			Node temp = stack2.pop();
			System.out.print(" " + temp.data + " ,");
		}
	}
}
