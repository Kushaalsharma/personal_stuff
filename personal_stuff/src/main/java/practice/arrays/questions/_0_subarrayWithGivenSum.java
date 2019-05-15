package practice.arrays.questions;

/*
 * Given an unsorted array A of size N of non-negative integers, 
 * find a continuous sub-array which adds to a given number K.
 */
public class _0_subarrayWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 15;
		subArrayWithGivenSum(arr, k);

		arr = new int[] { 1, 2, 3, 19, 2, 6 };
		k = 8;
		subArrayWithGivenSum(arr, k);

		arr = new int[] { 1, 2, 3, 19, 2, 6, 3 };
		k = 12;
		subArrayWithGivenSum(arr, k);
	}

	public static void subArrayWithGivenSum(int[] arr, int k) {
		int sum = arr[0], left = 0, right = 0;

		while (right < arr.length) {
			if (sum == k) {
				System.out.println("sum found at \nstarting position : " + left + " ,and ending position :" + right);
				break;
			} else if (sum < k && right < arr.length - 1) {
				right++;
				sum += arr[right];
			} else {
				// we have to make sure left do not jump over right
				// if (arr[x] >k)
				if (left == right) {
					if (left == arr.length - 1) {
						System.out.println("cant find a solution : ");
						break;
					}
					System.out.println("here");
					right++;
					left++;
					sum = arr[left];
				} else {
					sum -= arr[left];
					left++;
				}
			}
		}

	}
}