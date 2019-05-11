package treesAndGraphs.tree.boundryTraversals;

import treesAndGraphs.tree.Node;

public class _0_Right_View {

	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n left view of the Tree is :: \n\n");
		leftviewOfTree(root);

	}

	public static void leftviewOfTree(Node<Integer> root) {
		leftViewUtil(root, 1);
	}

	public static int maxlevel = 0;

	public static void leftViewUtil(Node root, int level) {
		if (root == null)
			return;
		if (level > maxlevel) {
			System.out.print(" " + root.data + ", ");
			maxlevel=level;
		}
		leftViewUtil(root.left, level + 1);
		leftViewUtil(root.right, level + 1);
	}
}
