package treesAndGraphs.graphs;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class dfs {
	public static void main(String[] args) {
		LinkedList<Integer>[] graph = getBasicGraph();
		System.out.println("D F S is : ");
		dfs(graph);
	}

	public static LinkedList<Integer>[] getBasicGraph() {
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[4];

		LinkedList<Integer> zero_links = new LinkedList<Integer>();
		zero_links.add(1);
		zero_links.add(2);
		graph[0] = zero_links;

		LinkedList<Integer> one_links = new LinkedList<Integer>();
		one_links.add(2);
		graph[1] = one_links;

		LinkedList<Integer> two_links = new LinkedList<Integer>();
		two_links.add(0);
		two_links.add(3);
		graph[2] = two_links;

		LinkedList<Integer> three_links = new LinkedList<Integer>();
		three_links.add(3);
		graph[3] = three_links;

		System.out.println("graph is :" + Arrays.toString(graph) + '\n');

		return graph;
	}

	/**
	 * @param : graph ( array of list of node) 0 -> 1->2->3
	 * 
	 * 
	 * 
	 */
	public static void dfs(LinkedList<Integer>[] graph) {
		int len = graph.length;
		boolean visited[] = new boolean[len];
		Arrays.fill(visited, false);

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				dfsUtil(graph, visited, i);
			}
		}
	}

	public static void dfsUtil(LinkedList<Integer>[] graph, boolean[] visited, int nodeIndex) {
		visited[nodeIndex] = true;

		Iterator<Integer> itr = graph[nodeIndex].iterator();

		while (itr.hasNext()) {
			int next_node_index = itr.next();
			if (!visited[next_node_index]) {
				dfsUtil(graph, visited, next_node_index);
			}
		}
		// after visiting all the childs and their child ... , print the node value.
		System.out.print("  " + nodeIndex + ", ");
	}
}
