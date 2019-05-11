package practice.arrays.binarysearch;

import static practice.arrays.binarysearch._0_arrayutil.print_array;

import java.util.Optional;

public class _3_find_first_or_last_occurance_in_sorted_array {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 4, 4, 4, 5, 6, 7 };
		int item = 4;
		Optional<Boolean> findFirst = Optional.of(false);
		System.out.println("find the first/last occurance of the repeated_character\n\n\n");
		int index = find_first_last_occurance(arr, item, findFirst);
		if (index != -1) {
			String str = "first";
			if (findFirst.get() != true)
				str = "last";
			System.out.println(str + " occurance of : " + item + " is at position : " + (index + 1));
		} else
			System.out.println("Element not found in the index");

	}

	public static int find_first_last_occurance(Integer[] arr, int item, Optional<Boolean> isFirst) {
		System.out.println("input array is : ");
		print_array(arr);
		System.out.println("item to find : " + item);

		int result = -1;
		int low = 0, high = arr.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == item) {
				result = mid;
				if (isFirst.get() == true)// to find the first_occurance of the item
					high = mid - 1;
				else
					low = mid + 1;
			} else if (item > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return result;
	}

}
