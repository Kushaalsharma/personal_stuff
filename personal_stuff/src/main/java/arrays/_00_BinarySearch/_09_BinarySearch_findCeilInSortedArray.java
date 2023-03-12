package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

public class _09_BinarySearch_findCeilInSortedArray {

    public static void main(String[] args)
    {
        int[] arr = {12, 14, 18, 21, 23, 26, 28, 29};
        int x =27; // try with 0,12, 22,27,30 also
        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        int res = indexOfCeilElementInSortedArray(arr, x);
        if (res == -1)
            System.out.println("No Ceil found for this element ( "+ x + " )");
        else
            System.out.println("Ceil Element for : " + x + " found at :" + res + " index , and value is : " + arr[res]);
    }

    public static int indexOfCeilElementInSortedArray(int inArr[], int x) {

        if (inArr == null || inArr.length == 0 )
            return -1;
        int start = 0, end = inArr.length - 1, mid;
        if (x <= inArr[start]) // ReadMe : IMP : negating lower bound in single shot
            return start;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            //System.out.println(" start : " + start + " , end : " + end + ", mid  : " + mid + ", Element[mid] : " + inArr[mid]);
            if ((inArr[mid] == x) ||
                    (inArr[mid] > x && (isValidIndex(mid - 1, inArr) && inArr[mid -1] < x)))
                //ReadMe: if element is equal to element at mid or is in between mid and mid-1
                return mid;

            if (x < inArr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static boolean isValidIndex(int inIndex, int[] inArr) {
        if (inIndex < 0 || inIndex >= inArr.length)
            return false;
        else
            return true;
    }
}
