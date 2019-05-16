package treesAndGraphs.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class _1_Topological_sort {
	public static void main(String[] args) {
		LinkedList<Integer>[] graph = dfs.getBasicGraph();
		System.out.println("Topological sort is : ");
		topologicalSort(graph, graph.length);
	}

	public static void topologicalSort(LinkedList<Integer>[] graph, int len) {

		boolean visited[] = new boolean[len];
		Arrays.fill(visited, false);

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				topologicalSortUtil(graph, visited, stack, i);
			}
		}

		// print the solution from the stack
		while (!stack.isEmpty()) {
			System.out.print(" " + stack.pop() + ", ");
		}
	}

	public static void topologicalSortUtil(LinkedList<Integer>[] graph, boolean[] visited, Stack<Integer> stack,
			int vertex) {
		visited[vertex] = true;
		// push it in the stack
		stack.push(vertex);
		Iterator<Integer> itr = graph[vertex].iterator();
		while (itr.hasNext()) {
			int next = itr.next();
			if (!visited[next]) {
				topologicalSortUtil(graph, visited, stack, next);
			}
		}
	}
}
