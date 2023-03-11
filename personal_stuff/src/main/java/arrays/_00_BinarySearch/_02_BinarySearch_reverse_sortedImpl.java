package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

public class _02_BinarySearch_reverse_sortedImpl {
    public static void main(String[] args) {

        int arr [] = {15,11,9,8,3,2};
        int x = 15;
        Arrays.stream(arr).forEach(i->System.out.print(i+" , "));
        System.out.println();
        int res = binarySearchReverseSortedImpl(arr,x);
        if ( res ==-1)
            System.out.println("Element "+x+" not found in the array.");
        else
            System.out.println("Element "+x+" found at "+ res +" Index.");
    }

    /**
     * Implementation of binary search algorithm.
     * In this find the element in mid of the search window.
     * If element is not found then reduce the search window by half and choose the right window by comparing where the element could be found.
     * IMPORTANT: if input array have duplicates, this function can return any match, it does not guarantee first or last occurrence match.
     *
     * @param inArr : reverse sorted input array in which element is to found.
     * @param x     : element to be found
     * @return -1 if element is not found, or array is empty.
     * If element is found then return index of the element
     */
    public static int binarySearchReverseSortedImpl(int[] inArr, int x) {
        if (inArr.length == 0)
            return -1; // element not found
        int start = 0, end = inArr.length - 1;
        while (start <= end) {
            int mid = ((end - start) / 2) +start;
            System.out.println("start : "+ start + " , End :" +end+ " , mid : "+mid);
            if (inArr[mid] == x)
                return mid;
            if (inArr[mid] < x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
