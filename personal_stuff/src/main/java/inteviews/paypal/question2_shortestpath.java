package inteviews.paypal;

import java.util.LinkedList;

public class question2_shortestpath {
	public static int ROW =4;
	public static int COL =5;
	
	//Driver program to test above function 
	public static void main(String [] args) 
	{ 
		int mat[][] = 
		{ 
			{ 1, 1, 1, 0, 1},
			{ 1, 0, 2, 0, 1},
			{ 0, 0, 1, 0, 1},
			{ 1, 0, 1, 1, 0}};

		Point source = null;
		for(int i = 0;i<mat.length;i++)
			for(int j = 0;j<mat[0].length;j++)
			{
				if (mat[i][j]==2)
					source = new Point(i, j);
			}
		if (source == null)
		{
			System.out.println("No Source found");
			//return -1 ;
		}
		int min_dist = BFS(mat, source); 
			System.out.println("Shortest Path is " + min_dist) ; 
			//return min_dist;
	}
	
	static boolean isSafe(int row, int col, int[][]mat, boolean [][]visited ) 
	{ 
		return ((row >= 0) && (row < ROW) && 
			(col >= 0) && (col < COL) && mat[row][col] == 0  && visited[row][col]); 
	} 
	
	static int BFS(int mat[][], Point src) 
	{ 

		boolean[][] visited = new boolean[ROW][COL];
		for (int i = 0;i<ROW;i++)
		{
			for ( int j = 0; j<COL;j++)
			{
				visited[i][j] = false;
			}
		}
		//These arrays are used to get row and column 
		//numbers of 4 neighbours of a given cell 
		int rowNum[] = {-1, 0, 0, 1}; 
		int colNum[] = {0, -1, 1, 0};
				
		// Mark the source cell as visited 
		visited[src.x][src.y] = true; 

		LinkedList<queueNode> q = new LinkedList<queueNode>(); 
		
		// Distance of source cell is 0 
		queueNode s = new queueNode(src, 0); 
		q.push(s); // Enqueue source cell 

		// Do a BFS starting from source cell 
		while (!q.isEmpty()) 
		{ 
			queueNode curr = q.peek(); 
			Point pt = curr.pt; 

			// If we have reached the destination cell, 
			// we are done 
			if (pt.x == ROW-1 && pt.y == COL-1) 
				return curr.dist; 

			// Otherwise dequeue the front cell in the queue 
			// and enqueue its adjacent cells 
			q.remove(); 

			for (int i = 0; i < 4; i++) 
			{ 
				int row = pt.x + rowNum[i]; 
				int col = pt.y + colNum[i]; 			
				if (isSafe(row, col,mat,visited)) 
				{ 
					// mark cell as visited and enqueue it 
					visited[row][col] = true; 
					Point p = new Point(row, col);
					queueNode Adjcell = new queueNode(p,curr.dist + 1 ); 
					q.push(Adjcell); 
				} 
			} 
		} 

		// Return -1 if destination cannot be reached 
		return -1; 
	} 
}

class Point 
{
	int x; 
	int y; 
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
} 

class queueNode 
{ 
	Point pt; 
	int dist; 
	public queueNode(Point p , int dist)
	{
		this.pt = pt;
		this.dist = dist;
	}
}


