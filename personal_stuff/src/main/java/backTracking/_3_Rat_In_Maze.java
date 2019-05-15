package backTracking;

public class _3_Rat_In_Maze {
	// matrix of N*N
	public static final int N = 4;

	public static void main(String[] args) {

	}

	public static void ratInMaze(int[][] maze) {
		int[][] sol = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = 0;
			}
		}
		//possible ways to explore the next cell
		//down, left, up, right
		int posR[] = {1,0,-1,0};
		int posC[] = {0,1,0,-1};
		//call the recursive function
		//TODO
		ratInMazeUtil(0,0,maze,sol,posR,posC);
		if (sol[N - 1][N - 1] == 1) {
			System.out.println("solution found");
			//print the solution matrix
		} else
			System.out.println("solution not found");
	}

	public static boolean ratInMazeUtil(int r, int c, int[][] maze, int[][] sol, int[] posR, int[] posC) {
		// base condition
		if (r == N - 1 && c == N - 1) // reached last cell
		{
			sol[N - 1][N - 1] = 1;
			return true;
		}
		for (int i = 0; i < N; i++) {
			int nextR = r + posR[i];
			int nextC = c + posR[i];

			// check if next position can we reached
			if (isSafe(nextR, nextC, sol, maze)) {
				sol[nextR][nextC] = 1;
				if (ratInMazeUtil(nextR, nextC, maze, sol, posR, posC))
					return true;
				else
					// backtrack
					sol[nextR][nextC] = 0;
			}

		}
		return false;
	}

	public static boolean isSafe(int r, int c, int[][] sol, int[][] maze) {
		if (r > 0 && r < N && c > 0 && c < N && maze[r][c] > 0 && sol[r][c] == 0)
			return true;
		else
			return false;
	}
}
