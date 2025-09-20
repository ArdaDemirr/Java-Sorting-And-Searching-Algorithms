/*
 *                                         JAVA BINARY SEARCH
 *
 * TIME COMPLEXITY: O(log(N))
 * BEST FOR SORTED DATASETS
 *
 * LOGIC:
 * 1. Binary Search works by repeatedly dividing the search interval in half.
 * 2. Compare the target value with the middle element of the array.
 *    - If equal, return the middle index.
 *    - If target is greater, search the right half of the array.
 *    - If target is smaller, search the left half of the array.
 * 3. Repeat until the target is found or the interval is empty.
 *
 * PARAMETERS:
 * - min: the starting index of the current search interval
 * - max: the ending index of the current search interval
 *
 * RESULT:
 * - Returns the index of the target value if found.
 * - Returns -1 if the target value is not in the array.
 */
import java.util.Scanner;
public class binarySearch {
    public static void main(String[] args) throws Exception 
    {
        int[] Array = {1,2,3,4,5,6,7,8,9};      // Must be sorted for binary search
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter the value that you want to search: ");
        int n = kb.nextInt();
        kb.close();
        int index = binarySearch(Array, n, 0,Array.length-1);
        if(index == -1)
        {
            System.out.println(n+" not found in the array!");
        } else 
        {
            System.out.println(n+" found in index "+index);
        }
    }
    private static int binarySearch(int[] Array, int n, int min, int max) 
    {
        if (min > max) {
            return -1;      // Target not found
        }
        int middle = (max + min) / 2;
        if (n == Array[middle])
        {
            return middle;
        }
        else if (n > Array[middle])
        {
            return binarySearch(Array, n, middle+1, max);   // Search right half
        }
        else
        {
            return binarySearch(Array, n, min, middle-1);   // Search left half
        }
    }
}