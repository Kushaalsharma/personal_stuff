package treesAndGraphs.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import treesAndGraphs.tree.Node;

public class _0_breath_first_search_using_queue {

	public static void main(String[] args) {
		Node root = Node.getBasicTree();
		System.out.println("\nBreadth first traversal using queue ::\n");
		bfsUsingQueue(root);
	}

	public static void bfsUsingQueue(Node<Integer> root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node temp = queue.remove();
				System.out.print(" " + temp.data + ", ");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			System.out.println();
		}
	}
}
