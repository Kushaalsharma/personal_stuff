package treesAndGraphs.tree.boundryTraversals;

import treesAndGraphs.tree.Node;

public class _0_Right_View {

	public static void main(String[] args) {
		Node<Integer> root = Node.getBasicTree();
		System.out.println("\n\n right view of the Tree is :: \n\n");
		rightViewOfTree(root);

	}

	public static void rightViewOfTree(Node<Integer> root) {
		rightViewUtil(root, 1);
	}

	public static int maxlevel = 0;

	public static void rightViewUtil(Node root, int level) {
		if (root == null)
			return;
		if (level > maxlevel) {
			System.out.print(" " + root.data + ", ");
			maxlevel=level;
		}
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
	}
}
