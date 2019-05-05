package DP;
import java.lang.Math;
import java.util.Arrays;

public class Longest_increasing_subsequence {
	/**
	 * this method return the length of longest subsequence
	 */
	private static int lcs(int [] arr)
	{
		int [] dp = new int [arr.length];
		//initialize with 1, as all number as single are longest comman subsequence
		for (int i =0; i<dp.length;i++)
		{
			dp[i] = 1;
		}
		//move two pointer i and j
		// calculate longest increasing subsequence till i pointer
		// for all i from 1(not from 0) to arr.length,
			// for all j from 0 to i( i is exclusive)
				// if arr[j] is smaller than arr[i] i.e. it is then dp[i] = max ( dp[i],dp[j]+1)
		
		for (int i =1; i<arr.length;i++)
		{
			for (int j =0;j<i;j++){
				if (arr[j]<arr[i])
				{
					dp[i] =Math.max(dp[i],dp[j]+1); 
				}
			}
		}
		
		return Arrays.stream(dp).max().getAsInt();
	}
	
	
	public static void main (String [] args)
	{
		int arr [] = {10,22,9,33,21,50,41,60};
		System.out.println(" "+lcs(arr));
		
	}

}
