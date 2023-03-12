package arrays._00_BinarySearch._00_BinarySearch;

import java.util.Arrays;

/*
* given the character x, Find the next character in the sorted array such that it is next in cronological order 
* and is present in the array.
* 
* Question : is array case sensitive ? if not, while comparing always use toLower function.
*/

public class _10_BinarySearch_findNextAlphabetInSortedArray {

    public static void main(String[] args)
    {
        char[] arr = {'a','b','e','g','i','j','k','p','x'};
        char x ='z'; // try with c,d,e,h,l,v,z also
        //Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        int res = indexOfCeilElementInSortedArray(arr, x);
        if (res == -1)
            System.out.println("No Ceil found for this element ( "+ x + " )");
        else
            System.out.println("Ceil Element for : " + x + " found at :" + res + " index , and value is : " + arr[res]);
    }

    public static int indexOfCeilElementInSortedArray(char inArr[], char x) {

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

    public static boolean isValidIndex(int inIndex, char[] inArr) {
        if (inIndex < 0 || inIndex >= inArr.length)
            return false;
        else
            return true;
    }
}
