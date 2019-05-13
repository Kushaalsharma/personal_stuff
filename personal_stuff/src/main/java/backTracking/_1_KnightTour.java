package backTracking;

/**
 * The knight is placed on the first block of an empty board and, moving
 * according to the rules of chess, must visit each square exactly once.
 */

public class _1_KnightTour {
	// chess is 8*8 board
	public static int N = 8;

	public static void main(String[] args) {
		solveKnightTravel();
	}

	public static void solveKnightTravel() {
		int[][] sol = new int[N][N];

		// initialize sol matrix with initial value (-1)
		// all unvisited blocks have value -1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = -1;
			}
		}

		// all possible moves
		//TODO : reason why this move matrix do not work 
//		int moveX[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
//		int moveY[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
		int moveX[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int moveY[] = { 1, 2,  2,  1, -1, -2, -2,-1 };
		
		// starting from 0,0 location
		sol[0][0] = 0;
		if (!solveKnightTravelUtil(0, 0, 1, sol, moveX, moveY)) {
			System.out.println("solution not found");
			// print the solution
		} else
			System.out.println("solution found");
		printSolution(sol);
	}

	public static boolean solveKnightTravelUtil(int x, int y, int moveNumber, int[][] sol, int[] moveX, int[] moveY) {
		int nextX, nextY,i;
		if (moveNumber == N * N)
			return true;
		for (i = 0; i < N; i++) {
			nextX = x + moveX[i];
			nextY = y + moveY[i];

			if (isSafe(nextX, nextY, sol)) {
				sol[nextX][nextY] = moveNumber;
				if (solveKnightTravelUtil(nextX, nextY,
						moveNumber + 1, sol, moveX, moveY))
					return true;
				else
					sol[nextX][nextY] = -1;
			}
		} // for loop ends here
		return false;
	}

	public static boolean isSafe(int x, int y, int sol[][]) {
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}

	static void printSolution(int sol[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}

}
