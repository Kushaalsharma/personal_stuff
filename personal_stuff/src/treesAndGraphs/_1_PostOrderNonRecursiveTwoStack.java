package treesAndGraphs;

import java.util.Stack;

public class _1_PostOrderNonRecursiveTwoStack {
	public static void main(String[] args) {
		Node root = Node.getBasicTree();
		System.out.println("postOrder :::  left ,right and then root");
		postOrderNonRecursive(root);
	}

	public static void postOrderNonRecursive(Node<Integer> node) {
		if (node == null)
			return;

		Stack<Node> stack1 = new Stack<Node>();
		
	}
}
