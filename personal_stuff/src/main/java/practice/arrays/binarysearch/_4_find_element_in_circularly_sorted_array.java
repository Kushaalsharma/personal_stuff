package practice.arrays.binarysearch;

import static practice.arrays.binarysearch._0_arrayutil.print_array;

public class _4_find_element_in_circularly_sorted_array {

	public static void main(String[] args) {
		Integer [] arr = {5,6,7,8,1,2,3,4};
		System.out.println("find the element in circularly sorted array ");
		int item =3;
		int index = find_Element_In_Circular_Sorted_Array(arr, item);
		if (index !=-1)
			System.out.println("element found at : "+ index + " index");
		else 
			System.out.println("element not found");

	}

	public static int find_Element_In_Circular_Sorted_Array(Integer[] arr, int item) {
		System.out.println("input array is :");
		print_array(arr);
		System.out.println("item to find is : "+ item);
		
		int low = 0, high = arr.length;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == item) //
				return mid;
			else if (arr[low] < arr[mid])// if left side is sorted
			{
				if (item >= arr[low] && item < arr[mid]) // item lies between low and mid
					high = mid - 1;
				else
					low = mid + 1;
			} else if (arr[mid] < arr[high]) // if right half is sorted
				if (item > arr[mid] && item < arr[high]) // if element can be in sorted part
					low = mid + 1;
				else
					high = mid -1;
		}
		return -1;
	}
}
