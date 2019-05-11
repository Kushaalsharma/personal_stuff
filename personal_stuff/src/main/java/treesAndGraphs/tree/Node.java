package treesAndGraphs.tree;

public class Node<T> {
	public T data;
	public Node<T> left;
	@SuppressWarnings("rawtypes")
	public Node right;

	public Node(T data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(T data) {
		this(data, null, null);
	}

	/**
	 * 10 5 15 3 7 13 17 2 4 6 8 11 14 16 18
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node<Integer> getBasicTree() {
		System.out.println("tree is ::: ");
		System.out.println("                              10");
		System.out.println("            5                                        15");
		System.out.println("     3                 7				   13                  17");
		System.out.println("   2   4            6     8             11    14             16    18");
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node11 = new Node(11);
		Node node14 = new Node(14);
		Node node16 = new Node(16);
		Node node18 = new Node(18);

		Node node3 = new Node(3, node2, node4);
		Node node7 = new Node(7, node6, node8);

		Node node13 = new Node(13, node11, node14);
		Node node17 = new Node(17, node16, node18);

		Node node5 = new Node(5, node3, node7);
		Node node15 = new Node(15, node13, node17);

		Node root = new Node(10, node5, node15);

		return root;
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		int lHeight = height(root.left);
		int rHeight = height(root.right);

		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
	}
}