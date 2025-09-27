/*
 *                                     JAVA QUICK SORT
 *
 * DESCRIPTION:
 * This program implements Quick Sort using median-of-three pivot selection
 * and two-pointer partitioning. This approach helps avoid worst-case
 * performance on nearly sorted arrays.
 *
 * TIME COMPLEXITY:
 *   - Average: O(N log N)
 *   - Worst-case: O(N^2) (rare due to median-of-three)
 *
 * SPACE COMPLEXITY:
 *   - O(log N) due to recursion stack
 *
 * LOGIC:
 * 1. Pick the median of the first, middle, and last elements as the pivot.
 * 2. Use two pointers to move elements smaller than pivot left and larger right.
 * 3. Recursively sort the left and right subarrays.
 */
public class quickSort {
    public static void main(String[] args) throws Exception 
    {
        int[] randomArray = {5,7,9,8,2,3,1,4,6};
        System.out.print("before Sorting: ");
        printArray(randomArray);
        quickSort(randomArray, 0, randomArray.length-1);    // Call quick sort
        System.out.print("After Sorting: ");
        printArray(randomArray);
    }

    private static void printArray(int[] randomArray) 
    {
        for (int i = 0; i < randomArray.length ; i++) 
        {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
    }
    
    private static void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high)     // Base case: subarray has more than 1 element
        {
            // Partition the array and get pivot index
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);    // recursion calls for smaller elements
            quickSort(arr, pi + 1, high);   // and greater or equals elements
        }
    }

    // Partition function using median-of-three and two-pointer scan
    private static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high); // Get median-of-three pivot
        int i = low;
        int j = high - 1; // Pivot is at arr[high]

        while (true) {
            // Move i right until arr[i] >= pivot
            while (i <= j && arr[i] < pivot) i++;

            // Move j left until arr[j] <= pivot
            while (j >= i && arr[j] > pivot) j--;

            // If pointers cross, break
            if (i >= j) break;

            // Swap out-of-place elements
            swap(arr, i, j);
            i++;
            j--;
        }
        // Place pivot in correct position
        swap(arr, i, high);
        return i; // Return pivot index
    }

    // Median-of-three function: arr[low], arr[mid], arr[high]
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Arrange so that arr[low] <= arr[mid] <= arr[high]
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        // Move median to high (pivot position)
        swap(arr, mid, high);

        return arr[high]; // Return pivot value
    }
}