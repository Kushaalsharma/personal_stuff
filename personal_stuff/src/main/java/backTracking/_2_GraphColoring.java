package backTracking;

import java.util.Arrays;

public class _2_GraphColoring {
	public static int nbVert = 4;

	public static void main(String[] args) {
		int [][] graph = {{0, 1, 1, 1}, 
						  {1, 0, 1, 0}, 
		                  {1, 1, 0, 1}, 
		                  {1, 0, 1, 0}};
		int m = 3;
		graphColoring(graph, m);

	}

	public static void graphColoring(int[][] graph, int m) {
		int[] color = new int[nbVert];
		for (int i = 0; i < nbVert; i++)
			color[i] = 0;

		if (graphColoringUtil(graph, m, 0, color)) {
			System.out.println("solution possible");
			printSolution(color);
		} else {
			System.out.println("solution not possible");
		}
	}

	public static boolean graphColoringUtil(int[][] graph, int m, int vert, int[] color) {
		if (vert == nbVert)
			return true;
		for (int c = 1; c <= m; c++) {
			if (isSafe(graph, c, color, vert)) {
				// if it safe to put color c here , then
				color[vert] = c;
				if (graphColoringUtil(graph, m, vert + 1, color))
					return true;
				else {
					color[vert] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] graph, int c, int color[], int vert) {
		// if there exist a edge and color of adjacent node not equals to chosen color
		// (c)
		for (int i = 0; i < nbVert; i++) {
			if (graph[i][vert] != 0 && c == color[i])
				return false;
		}
		return true;
	}

	public static void printSolution(int color[]) {
		boolean rand = Math.random() > 0.5 ? true : false;
		if (rand) {
			for (int i : color)
				System.out.print(" " + i + ", ");
		} else
			System.out.println(Arrays.toString(color));
	}
}
