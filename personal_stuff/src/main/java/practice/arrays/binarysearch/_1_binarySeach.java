package practice.arrays.binarysearch;

import static practice.arrays.binarysearch._0_arrayutil.print_array;

public class _1_binarySeach {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		int item = 5;
		int index = bSearch(arr, item);
		if (index != -1)
			System.out.println("item found at index : " + index);
		else
			System.out.println("item not found in the array");
	}

	private static int bSearch(Integer[] arr, Integer item) {
		System.out.println("searching item : " + item + ",in array : ");
		print_array(arr);
		int high = arr.length, low = 0;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == item)
				return mid;
			else if (item > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		// if no element is found
		return -1;
	}
}
