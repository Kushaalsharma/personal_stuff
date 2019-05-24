package inteviews.microsoft;

public class _4_Clone_A_linked_list_With_random_pointer {
	public static void main(String[] args) {
		Node root = Node.getLinkedList();
		Node.printList(root);
		cloneRandomList(root);

	}

	public static Node cloneRandomList(Node root) {
		if (root == null)
			return null;
		Node ptr = root;
		while (ptr.next != null) {
			Node newNode = new Node(ptr.data);
			newNode.next = ptr.next;
			ptr = newNode.next;
		}
		Node.printList(root);
		// add random pointers
		ptr = root;
		while (ptr.next != null) {
			Node new_node = ptr.next;
			Node random_pointer = ptr.random;
			new_node.random = random_pointer.next;
			ptr = ptr.next.next;
		}

		Node newRoot = root.next;
		while (root != null) {
			ptr =root.next;
			//remove old list 
			root.next = root.next.next;
			ptr.next =ptr.next.next;
		}
		Node.printList(newRoot);
		return newRoot;
	}

}

class Node {
	int data;
	Node next;
	Node random;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.random = null;
	}

	public static Node getLinkedList() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		// assign random pointers
		node1.random = node3;
		node2.random = node1;
		node3.random = node6;
		node4.random = node4;
		node5.random = node2;
		node6.random = node5;

		return node1;
	}

	public static void printList(Node node) {
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print(" null");
	}

}
