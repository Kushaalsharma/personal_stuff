package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

public class _05_BinarySearch_No_of_times_Array_rotated {

    public static void main ( String [] args)
    {
        int [] arr = {2,4,5,6,7,0,1};
        int x = 1;
        Arrays.stream(arr).forEach(i-> System.out.print(i+ ", "));
        int res = binarySearchNoOfTimesArrayRotated(arr);
        if (res == -1)
            System.out.println("Array is either null or empty !");
                System.out.println("Array rotated : " +res+ " times");
    }


    /**
     * Function to find the element
     * @param inArr
     * @return
     */
    public static int binarySearchNoOfTimesArrayRotated(int[] inArr)
    {
        if ( inArr == null || inArr.length == 0)
            return -1;
        int len = inArr.length-1;
        int start=0,end=len,mid;
        while ( start <=end)
        {
            mid = start + ((end-start)/2);
            System.out.println("Start : "+start+ " , end "+end+ ", mid : "+mid  );
            int next = (mid +1) %len ; //%TODO : Readme % Len to avoid arrayIndex out of bound ( where mid = max= last element of array)
            int prev = (mid -1 +len) %len; // %TODO : README +Len to avoid prev to become negative (where mid = start = first element of array)
            if ( inArr[mid]<inArr[prev] && inArr[mid]<inArr[next]) // pivot element, which is smaller than both Previous and end.
                return mid;
            else if ( inArr[start] < inArr[mid]) // this part is sorted .. so discard
                start = mid+1;
            else
                end = mid-1;
        }
        return 0;
    }
}
