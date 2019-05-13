package sorting_algo;

public class _4_MergeSort {

	public static void main(String[] args) {
		System.out.println(" Runing Bubble sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		arr = mergeSort(arr);
		System.out.println(" \n sorted array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		if (len < 2)
			return arr;

		int mid = len / 2;
		int[] left = new int[mid];
		int[] right = new int[len - mid];

		for (int i = 0; i < mid; i++)
			left[i] = arr[i];
		for (int j = 0; j < len - mid; j++)
			right[j] = arr[mid + j];

		left = mergeSort(left);
		right = mergeSort(right);

		// merge left and right elements
		arr = merge(left, right);
		return arr;
	}

	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				result[k] = left[i];
				i++;
			} else {
				result[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			result[k] = left[i];
			i++;
			k++;
		}
		while (j < left.length) {
			result[k] = left[j];
			j++;
			k++;
		}
		return result;
	}
}
