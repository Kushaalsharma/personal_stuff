package sorting_algo;

public class _3_SelectionSort {
	public static void main(String[] args) {
		System.out.println(" Runing Bubble sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		arr = selectionSort(arr);
		System.out.println(" \n sorted array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}

	}

	public static int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			// select the minimum index
			int iMin = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[iMin])
					iMin = j;
			}
			if (iMin != i) // if any smaller element is found then swap
			{
				int temp = arr[iMin];
				arr[iMin] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

}
