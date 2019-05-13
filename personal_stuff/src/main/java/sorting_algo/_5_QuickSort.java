package sorting_algo;

public class _5_QuickSort {

	public static void main(String[] args) {
		System.out.println(" Runing Bubble sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		quickSort(arr);
		System.out.println(" \n sorted array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static void quickSort(int[] arr) {
		quickSortUtil(arr, 0, arr.length-1);
	}

	public static void quickSortUtil(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pindex = partition(arr, start, end);
		quickSortUtil(arr, start, pindex - 1);
		quickSortUtil(arr, pindex + 1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pindex = start;
		int pivot = arr[end];

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				// swap pindex and arr[i]
				// increement pindex
				int temp = arr[pindex];
				arr[pindex] = arr[i];
				arr[i] = temp;
				pindex++;
			}
		}
		// swap element at pindex and end
		int temp = arr[pindex];
		arr[pindex] = arr[end];
		arr[end] = temp;

		return pindex;
	}

}
