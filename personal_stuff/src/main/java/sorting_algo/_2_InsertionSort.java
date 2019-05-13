package sorting_algo;

public class _2_InsertionSort {

	public static void main(String[] args) {
		System.out.println(" Running insertion sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		arr = insertionSort(arr);
		System.out.println(" \n sorted array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int hole = i;
			int value = arr[i];
			// move un-till you find the correct position for value;
			// copy value of hole-1 to hole
			// ( we have already taken a copy of arr[i] into value)
			while (hole > 0 && value < arr[hole - 1]) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
		return arr;
	}
}
