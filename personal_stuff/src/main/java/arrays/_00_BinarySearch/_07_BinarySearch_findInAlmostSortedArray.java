package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

/**
 * find the element in a nearly sorted array !
 * Nearly sorted array is where elements are sorted and maximum they can be found at i-1, i or i+1 location, where i is the rightful location, if array was sorted.
 */

public class _07_BinarySearch_findInAlmostSortedArray {

    public static void main( String [] args)
    {
        int arr[] = {5,10,30,20,40};
        int x =02;
        Arrays.stream(arr).forEach(i->System.out.print(i+" , "));
        System.out.println();

        int res = findInAlmostSorted(arr,x);
        if (res == -1 )
            System.out.println(" Element : "+ x +" not found in the array!");
        else
            System.out.println("Element : " + x + "found at : " + res + " Index!");
    }

    /**
     *  Find the element where array is almost sorted.
     *  it is normal like binary search, just make sure to check the mid, mid-1 and mid +1 positions
     *  and when choosing the half move to either mid-2 or mid+2 as we have already checked mid -1 and mid +1 indexes.
     * @param inArr Almost sorted Array
     * @param x element to be found.
     * @return -1 if element is not found.
     *          index of the element in the array.
     */
    public static int findInAlmostSorted(int[] inArr, int x)
    {
        if (inArr == null || inArr.length ==0)
            return -1;
        int start =0, end=inArr.length-1,mid;

        while(start<=end)
        {
            mid = start + ((end-start)%2);
            if (inArr[mid] == x)
                return mid;
            else if (isInBound(mid-1,inArr) && inArr[mid-1] ==x)
                return mid -1;
            else if (isInBound(mid+1,inArr) && inArr[mid+1] ==x)
                return mid+1;
            else if (x<inArr[mid])
                end = mid -2; // we have already checked mid and mid-1 elements;
            else
                start = mid +2; // we have already checked mid and mid+1 elements;
        }
        return -1;
    }


    public static boolean isInBound(int inIndex, int[] inArr)
    {
        if ( inIndex < 0 || inIndex >= inArr.length )
            return false;
        else
            return  true;
    }
}
