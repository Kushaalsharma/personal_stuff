package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

public class _03_BinarySearch_Unknown_OrderImpl {
    public static void main ( String [] args)
    {
//        int arr [] = {1,3,5,8,9,11};
//        int x = 9;
        int arr [] = {15,11,9,8,3,2};
        int x = 2;
        Arrays.stream(arr).forEach(i-> System.out.print(i +" , "));
        System.out.println();

        int res = binarySearchUnknownOrder(arr,x);
        if ( res == -1)
            System.out.println("Element " + x +" not found in the input array.");
        else
            System.out.println("Element "+ x +" found at "+ res + " index.");
    }


    /**
     * Implementation of binary search algorithm for sorted array of unknown order.
     * IMPL details:
     * find the order ( asc or desc ) then use it defining which way to choose when mid > x
     * find the element in mid of the search window.
     * If element is not found then reduce the search window by half and choose the right window by comparing where the element could be found.
     * IMPORTANT: if input array have duplicates, this function can return any match, it does not guarantee first or last occurrence match.
     *
     * @param inArr : reverse sorted input array in which element is to found.
     * @param x     : element to be found
     * @return -1 if element is not found, or array is empty.
     * If element is found then return index of the element
     */
    public static int binarySearchUnknownOrder(int [] inArr, int x)
    {
        if ( inArr ==null || inArr.length ==0)
            return -1;

        boolean isAsc = isAscending(inArr);
        int start =0,end = inArr.length-1;
        int mid =0;
        while ( start <=end)
        {
            mid =start + ((end - start)/2);
            //System.out.println("Start : "+start+ " , end "+end+ ", mid : "+mid  );
            if(inArr[mid] == x)
                return mid;
            else if (x > inArr[mid])
            {
                if(isAsc)
                    start = mid+1;
                else // array is sorted in reverse order
                    end = mid-1;
            }
            else
            {
                if ( isAsc)
                    end = mid-1;
                else  // array is sorted in reverse order
                    start =mid+1;
            }
        }
        return -1;
    }


    /**
     * Checks if input array is sorted in ascending or descending order
     * @param inArr  : sorted input array
     * @return : True is array is sorted in ascending order , else return false.
     */
    public static boolean isAscending(int[] inArr)
    {
        if (inArr[0] <= inArr[inArr.length-1]) {
            System.out.println("Array is in ascending order!");
            return true;
        }
        else
        {
            System.out.println("Array is in Descending order !");
            return false;
        }
    }
}
