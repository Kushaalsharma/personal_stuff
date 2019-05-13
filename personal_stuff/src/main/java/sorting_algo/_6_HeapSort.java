package sorting_algo;

import java.util.Arrays;

public class _6_HeapSort {

	public static void main(String[] args) 
	{
		System.out.println(" Runing Bubble sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: "+Arrays.toString(arr));
		heapsort(arr);
		System.out.println(" \n sorted array is :: " + Arrays.toString(arr));

	}

	public static void	 heapsort(int[] arr) {

		int n = arr.length;
		for (int i = (n/ 2) - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		
		for(int i =0;i<n-1;i++)
		{
			//swap first element with arr.lenght--1-i elements;
			//heapify (the top node with size = length-i
			int temp = arr[0];
			arr[0] = arr[n-i-1];
			arr[n-i-1] = temp;
			heapify(arr,n-i-1,0);
			
		}
	}

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = (i * 2) + 1;
		int right = (i * 2) + 2;

		// check if any child ( left or right is greater)
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		// if largest have changed then swap the elements ( largest with i)
		// and heapify again (i)
		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;

			heapify(arr, n, largest);
		}
	}
}
