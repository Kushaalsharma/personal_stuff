package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

/**
 * Find the floor of the element in the  sorted array ?
 * floor is defined as the largest number in the array, which is smaller /equal to the given number (x)
 */
public class _08_BinarySearch_FindFloorInSortedArray {

    public static void main ( String [] args)
    {

        int [] arr = {12,14,18,21,23,26,28,29};
        int x =80; // try with 0,12, 22,27,30 also
        Arrays.stream(arr).forEach(i-> System.out.print(i+ ", "));
        System.out.println();

        int res = indexOfFloorElementInSortedArray(arr,x);
        if (res == -1)
            System.out.println("Element : "+x+" not found in the array!");
        else
            System.out.println("Floor of  : " + x + " found at : " +res+ " index , and value is : " + arr[res]);
    }

    public static int indexOfFloorElementInSortedArray (int inArr[], int x)
    {
        if (inArr == null || inArr.length == 0 || inArr[0]>x)
            return  -1;
         int start = 0, end = inArr.length-1, mid ;
         if (x >= inArr[end])
            return end;

         while (start <=end)
         {
             mid = start +((end -start)/2);
             //System.out.println(" start : " +start + " , end : "+end + ", mid  : "+ mid + ", Element[mid] : "+ inArr[mid]);
             if((inArr[mid]==x) || ( inArr[mid]<=x && (isValidIndex(mid+1,inArr) && inArr[mid+1]> x)))
                 return  mid;

             if ( x < inArr[mid])
                 end = mid-1;
             else
                 start = mid+1;
         }
         return  -1;
    }

    public static boolean isValidIndex(int inIndex, int[] inArr)
    {
        if(inIndex <0 || inIndex>=inArr.length)
            return false;
        else
            return true;
    }
}
