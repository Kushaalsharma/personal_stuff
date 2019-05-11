package treesAndGraphs.tree.boundryTraversals;

import treesAndGraphs.tree.Node;
import treesAndGraphs.tree.boundryTraversals._0_leaf_view;

public class _1_boundryTraversal {

	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n boundry view of the Tree is :: \n\n");
		// TO avoid printing root node twice(from leftView and rightView)
		// print it separately
		if (root != null)
		{
			System.out.print(" " + root.data + ", ");
			boundrylefttraversal(root.left);
			_0_leaf_view.leaf_view(root.left);
			_0_leaf_view.leaf_view(root.right);
			boundryRightTraversal(root.right);

		}
//
//		boundrylefttraversal(root);
//		_0_leaf_view.leaf_view(root);
//		boundryRightTraversal(root);
	}

	/**
	 * print left view but do not print the leaf view i.e print only if there is any
	 * left or right child
	 */
	public static void boundrylefttraversal(Node node) {
		if (node != null) {
			if (node.left != null) {
				System.out.print(" " + node.data + ", ");
				boundrylefttraversal(node.left);
			} else if (node.right != null) {
				System.out.print(" " + node.data + ", ");
				boundrylefttraversal(node.right);
			}
		}
	}

	/**
	 * print right view but do not print the leaf view i.e print only if there is
	 * any right or left child
	 */
	public static void boundryRightTraversal(Node node) {
		if (node == null)
			return;
		if (node.right != null) {
			// to see bottom up view ( as it anticlock wise) first traverse to last right
			// and then print
			boundryRightTraversal(node.right);
			System.out.print(" " + node.data + ", ");
		} else if (node.left != null) {
			boundryRightTraversal(node.left);
			System.out.print(" " + node.data + ", ");
		}
	}
}
