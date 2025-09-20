/*
 *                                         JAVA LINEAR SEARCH
 *
 * TIME COMPLEXITY: O(N)
 * BEST FOR SMALL OR UNSORTED DATASETS
 *
 * LOGIC:
 * 1. Start from the first element of the array.
 * 2. Compare each element with the target value (the value to search for).
 *    - If a match is found, return the index of that element.
 * 3. If no element matches the target after checking the entire array, return -1 to indicate "not found".
 *
 * OUTER LOOP:
 * - Iterates through all elements of the array from index 0 to the last.
 * - Checks each element sequentially.
 *
 * RESULT:
 * - Returns the index of the first occurrence of the target value.
 * - Returns -1 if the target value is not present in the array.
 */
import java.util.Scanner;
public class linearSeach {
    public static void main(String[] args) throws Exception 
    {
        int[] Array = {1,2,3,4,5,6,7,8,9};
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter the value that you want to search: ");
        int n = kb.nextInt();
        kb.close();
        int index = linearSearch(Array, n);
        if(index == -1)
        {
            System.out.println(n+" not found in the array!");
        } else 
        {
            System.out.println(n+" found in index "+index);
        }
    }
    private static int linearSearch(int[] Array, int n) 
    {
        // Iterate through each element of the array
        for (int i = 0 ; i < Array.length ; i++)
        {
            // Check if the current element matches the target
            if (n == Array[i])
            {
                return i;   // Target found, return index
            }
        }
        return -1;  // Target not found
    }
}