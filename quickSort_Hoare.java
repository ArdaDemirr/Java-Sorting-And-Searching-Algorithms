/*
 *                                   JAVA QUICK SORT (HOARE PARTITION)
 *
 * DESCRIPTION:
 * This program implements Quick Sort using Hoare's partitioning scheme.
 * It uses two pointers that start from both ends and move toward each other,
 * swapping elements that are on the wrong side of the pivot.
 * This version performs fewer swaps than Lomuto’s and is often faster in practice.
 *
 * TIME COMPLEXITY:
 *   - Average: O(N log N)
 *   - Worst-case: O(N^2) (occurs when pivot selection is poor, e.g. sorted input)
 *
 * SPACE COMPLEXITY:
 *   - O(log N) due to recursion stack
 *
 * LOGIC:
 * 1. Select the pivot (commonly the middle element).
 * 2. Increment the left pointer until an element ≥ pivot.
 * 3. Decrement the right pointer until an element ≤ pivot.
 * 4. Swap the two elements if left < right.
 * 5. Repeat until pointers cross, then recursively sort both sides.
 */

public class quickSort_Hoare {

    // partition using Hoare's scheme
    public static int partition(int[] A, int low, int high) {
        int pivot = A[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (A[i] < pivot);

            do {
                j--;
            } while (A[j] > pivot);

            if (i >= j)
                return j;

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    // recursive quicksort
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int p = partition(A, low, high);
            quickSort(A, low, p);
            quickSort(A, p + 1, high);
        }
    }

    // driver
    public static void main(String[] args) {
        int[] A = {10, 7, 8, 9, 1, 5};
        quickSort(A, 0, A.length - 1);
        System.out.print("Sorted array (Hoare): ");
        for (int num : A) System.out.print(num + " ");
        System.out.println();
    }
}
