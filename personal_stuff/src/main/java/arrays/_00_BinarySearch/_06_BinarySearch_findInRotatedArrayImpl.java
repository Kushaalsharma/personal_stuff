package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

public class _06_BinarySearch_findInRotatedArrayImpl {

    public static void main ( String [] args)
    {
        int [] arr = {12,4,18,21,3,6,8,9};
        int x = 133;
        Arrays.stream(arr).forEach(i-> System.out.print(i+ ", "));
        System.out.println();

        int res = indexOfElementInCircularSortedArray(arr,x);
        if (res == -1)
            System.out.println("Element : "+x+" not found in the array!");
        else
            System.out.println("Element : "+x+" found at :" +res+ " index");
    }

    public static int indexOfElementInCircularSortedArray( int [] inArr, int x)
    {
        if ( inArr == null || inArr.length ==0)
        return -1;
        int len = inArr.length-1;
        int start = 0, end = len,mid;

        while ( start <=end)
        {
            mid = start + ((end-start)/2);
            if ( inArr[mid] ==x)
                return mid;
            int prev = (mid-1+len) % len;
            int next = (mid+1) % len;

            if (inArr[start]<inArr[prev]) // right side is sorted
            {
                if (x>=inArr[start] && x<=inArr[prev]) // x is between start and prev
                    end = mid - 1;
                else
                    start = mid + 1; // x is not in between start and mid-1, so search in unsorted half
            }
            else // left half is sorted
            {
                if (x>=inArr[next] && x<=inArr[end]) // x is between next and end
                    start = mid+1;
                else
                    end =mid-1;
            }

        }
        return -1;
    }
}
