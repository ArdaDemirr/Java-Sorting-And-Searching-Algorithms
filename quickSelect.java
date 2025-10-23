/*
 *                                   JAVA QUICK SELECT
 *
 * DESCRIPTION:
 * This program implements the Quickselect algorithm using Hoare's partitioning scheme.
 * Quickselect finds the k-th smallest element in an unsorted array efficiently.
 * Unlike Quicksort, it only recurses into the partition containing the target element,
 * giving an average time complexity of O(N).
 *
 * TIME COMPLEXITY:
 *   - Average: O(N)
 *   - Worst-case: O(N^2) (occurs when pivot selection is poor, e.g., sorted input)
 *
 * SPACE COMPLEXITY:
 *   - O(log N) due to recursion stack
 *
 * LOGIC:
 * 1. Select a pivot (middle element) for partitioning.
 * 2. Move left pointer forward until element ≥ pivot.
 * 3. Move right pointer backward until element ≤ pivot.
 * 4. Swap elements at left and right pointers if left < right.
 * 5. Partition returns index of pivot boundary.
 * 6. Recurse only into the side containing the target element.
 * 7. Stop when low == high, returning the k-th smallest element.
 *
 * ADDITIONAL:
 * - User input is validated using try-catch to ensure an integer is entered.
 * - Supports 1-based user input for the k-th smallest element.
 */

import java.util.Scanner;


public class quickSelect {

    // Hoare's partitioning scheme
    public static int partition(int[] A, int low, int high) {
        int pivot = A[(low + high) / 2];    // choose middle element as pivot
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (A[i] < pivot);     // move i forward while A[i] < pivot

            do {
                j--;
            } while (A[j] > pivot);     // move j backward while A[j] > pivot

            if (i >= j)                 // pointers crossed, partition done
                return j;

            // swap elements at i and j
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    // Quickselect recursive function
    public static int quickSelect(int[] A, int low, int high, int target) {
        if (low == high) {  // base case: only one element
            return A[low];
        }
        int p = partition(A, low, high);    // partition the array
        
        // recurse only on the side containing the target
        if (target <= p)
        {
            return quickSelect(A, low, p, target);
        }
        else
        {
            return quickSelect(A, p+1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 7, 8, 9, 1, 5};
        for (int i : A) 
        {
            System.out.print(i + " ");  // print array elements
        }
        System.out.println(); // newline
        Scanner kb = new Scanner(System.in);
        int target = -1;

        // read and validate user input
        while (true) 
        {
            System.out.print("Enter which smallest element to find from the array that appears at the top: ");
            try 
            {
                target = Integer.parseInt(kb.nextLine()); // safer than nextInt()
                if (target < 1) 
                {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;  // valid input
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        kb.close();
        int value =quickSelect(A, 0, A.length - 1, target-1);   // find k-th smallest element (convert 1-based to 0-based index)
        System.out.println("The " + target + "rd smallest element: " + value);  // print result
    }
}
