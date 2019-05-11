package treesAndGraphs.tree.depthFirstTraversals;

import java.awt.print.Printable;
import java.util.Stack;

import treesAndGraphs.tree.Node;

public class _1_PreOrderNonRecursive {
	public static void main(String[] args) {
		Node root =  Node.getBasicTree();
		System.out.println("Preorder :::  root, left and then right");
		preOrderNonRecursive(root);
	}

	public static void preOrderNonRecursive(Node<Integer> node) {
		if (node == null)
			return;

		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(node);

		while (!stack.isEmpty()) {
			Node<Integer> current = stack.pop();
			System.out.print(" " + current.data + " ,");
			/*
			 * Note: we are pushing right first , because if we push left first and right
			 * after that then while popping we will get right first, which we don't want.
			 */
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);
		}
	}

}
