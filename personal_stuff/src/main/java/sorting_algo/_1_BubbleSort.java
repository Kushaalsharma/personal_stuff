package sorting_algo;

public class _1_BubbleSort {
	public static void main(String[] args) {
		System.out.println(" Runing Bubble sort");
		int arr[] = { 10, 9, 1, 3, 7, 4 };
		System.out.println(" input array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		arr = bubbleSort(arr);
		System.out.println(" \n sorted array is :: ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static int [] bubbleSort(int [] arr)
	{
		for (int i =0;i<arr.length;i++)
		{
			for (int j = i+1;j<arr.length;j++)
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
		}
		return arr;
	}

}
