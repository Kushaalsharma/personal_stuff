package practice.arrays.binarysearch;

import static practice.arrays.binarysearch._0_arrayutil.print_array;

public class _2_count_no_of_times_array_is_rotated {

	public static void main(String[] args) {
		Integer arr[] = {4,5,6,7,8,1,2,3};
		System.out.println("array is rotated : "+count_array_rotated(arr)+ " times.");
}

	public static int count_array_rotated(Integer[] arr) {
		System.out.println(" input  circularly sorted array is : ");
		print_array(arr);
		System.out.println(" please note this will not work if it contain duplicates ");

		int low = 0, high = arr.length;

		while (low < high) {
			int mid = low + (high - low) / 2;
			// search for pivot ... pivot is smaller than element on left and element on
			// right
			int prev = arr[mid - 1], next = arr[mid + 1];
			//System.out.println(" prev : "+ prev +" , next : "+next+ ",arr[mid] : " +arr[mid]);
			if (arr[mid] < prev && arr[mid] < next)
				// no of times array is rotated is index of pivot
				return mid;
			else if (arr[low] < arr[mid])
				// left half is sorted , which means it do not have pivot
				// note we have to include the mid also.. low = mid instead of low = mid + 1
				low = mid;
			else
				high = mid;
		}
		return 0;
	}
}
