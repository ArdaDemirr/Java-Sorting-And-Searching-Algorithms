/*
 *                                   JAVA QUICK SORT (LOMUTO PARTITION)
 *
 * DESCRIPTION:
 * This program implements Quick Sort using Lomuto's partitioning scheme.
 * It uses the last element as the pivot and rearranges the array so that
 * all elements smaller than the pivot come before it, and all greater ones after.
 * This version is simpler to implement but performs more swaps than Hoare’s.
 *
 * TIME COMPLEXITY:
 *   - Average: O(N log N)
 *   - Worst-case: O(N^2) (when the array is already sorted or reverse sorted)
 *
 * SPACE COMPLEXITY:
 *   - O(log N) due to recursion stack
 *
 * LOGIC:
 * 1. Choose the last element as the pivot.
 * 2. Maintain an index `i` for the smaller element boundary.
 * 3. Iterate `j` through the array and swap when A[j] ≤ pivot.
 * 4. After the loop, place the pivot between smaller and larger elements.
 * 5. Recursively sort left and right partitions.
 */

public class quickSort_Lomuto {

    // partition using Lomuto's scheme
    public static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    // recursive quicksort
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int p = partition(A, low, high);
            quickSort(A, low, p - 1);
            quickSort(A, p + 1, high);
        }
    }

    // driver
    public static void main(String[] args) {
        int[] A = {10, 7, 8, 9, 1, 5};
        quickSort(A, 0, A.length - 1);
        System.out.print("Sorted array (Lomuto): ");
        for (int num : A) System.out.print(num + " ");
        System.out.println();
    }
}
