package practice.arrays.questions;

/*
 Write an efficient program to find the sum of contiguous subarray 
 within a one-dimensional array of numbers which has the largest sum.
 */
public class _1_sub_Arrays_with_max_sum {

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		subArrayithMaxSum(a);

		int a1[] = { -1, -1, -1, -1 };
		subArrayithMaxSum(a1);

		int a2[] = { -1, -1, -3 };
		subArrayithMaxSum(a2);

		int a3[] = { -1, -1, -3, -1 };
		subArrayithMaxSum(a3);
	}

	public static void subArrayithMaxSum(int[] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		int start = 0, end = 0;

		for (int i = 0; i < arr.length; i++) {
			max_ending_here += arr[i];
			if (max_ending_here > max_so_far) {
				// include i in the range
				max_so_far = max_ending_here;
				end = i;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
				start = i + 1;
			}
		}
		// if max_so_far is always negative
		if (max_so_far < 0) {
			start = end = start - 1;
		}
		System.out.println("Maximum contiguous sum is : " + max_so_far);
		System.out.println("start Index : " + start + ", end INdex : " + end);
	}

	public static void printsum____subArraysWithMaxSum(int[] arr) {
		int len = arr.length;
		int max = arr[0];
		int currentMax = arr[0];
		for (int i = 1; i < len; i++) {
			currentMax = Math.max(arr[i], currentMax + arr[i]);
			max = Math.max(currentMax, max);
		}

	}
}
