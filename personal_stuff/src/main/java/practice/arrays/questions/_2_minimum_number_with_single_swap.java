package practice.arrays.questions;

import java.util.Arrays;

public class _2_minimum_number_with_single_swap {
	public static void main(String[] args) 
	{
		String str = "934651";
		minimum_number(str);

	}

	public static String minimum_number(String str) {
		char arr[] = str.toCharArray();
		int n = str.length();
		int[] rightMin = new int[n];
		Arrays.fill(rightMin, -1);

		rightMin[n - 1] = -1;
		int r = n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > arr[r]) {
				rightMin[i] = r;
			} else {
				rightMin[i] = -1;
				r = i;
			}
		}
		System.out.println("array is :           " + Arrays.toString(arr));
		System.out.println("right min array is : " + Arrays.toString(rightMin));

		for (int i = 0; i < n; i++) {
			if (rightMin[i] != -1) {
				// swap arr[i] and arr[rightMin[i]]
				char temp = arr[i];
				arr[i] = arr[rightMin[i]];
				arr[rightMin[i]] = temp;
				break;
			}
		}
		System.out.println(" minimum possible array with one swap is: "+Arrays.toString(arr));
		return new String (arr);
	}

}
