/*
 *                                     JAVA MERGE SORT
 *
 * TIME COMPLEXITY: O(N * log(N))
 * SPACE COMPLEXITY: O(N) (extra arrays created for merging)
 *
 * LOGIC:
 * 1. Split the array into two halves (left and right).
 * 2. Recursively sort both halves until subarrays of size 1 remain.
 * 3. Merge the sorted halves back together into one sorted array.
 *
 * OUTER LOGIC (mergeSort):
 * - Divide the array into halves until you reach size <= 1 (base case).
 * - Recurse on left half and right half.
 * - Merge them back into the original array.
 *
 * INNER LOGIC (merge):
 * - Compare elements from left and right subarrays.
 * - Pick the smaller one and place it into the original array.
 * - Copy any remaining elements from left or right after one side is exhausted.
 *
 * RESULT:
 * - Fully sorted array in ascending order.
 */
public class mergeSort {
    public static void main(String[] args) throws Exception 
    {
        int[] randomArray = {5,7,9,8,2,3,1,4,6};

        System.out.print("before Sorting: ");
        printArray(randomArray);

        mergeSort(randomArray);                         // Call merge sort

        System.out.print("After Sorting: ");
        printArray(randomArray);
    }

    private static void printArray(int[] randomArray) {
        for (int i = 0; i < randomArray.length ; i++) 
        {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
    }

    // Recursive merge sort function
    private static void mergeSort(int[] randomArray) 
    {
        int length = randomArray.length;

        if (length <= 1)                    // BASE CASE: arrays of size 1 are already sorted
        {
            return;
        }

        int middle = length / 2;           // Find the midpoint

        // Create left and right subarrays
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        // Fill left and right arrays
        for(int i = 0; i < length; i++)
        {
            if (i < middle)
            {
                leftArray[i] = randomArray[i];
            }
            else
            {
                rightArray[i - middle] = randomArray[i];
            }
        }
        // Recursively sort both halves
        mergeSort(leftArray);
        mergeSort(rightArray);
        // Merge the sorted halves back into arr
        merge(leftArray, rightArray, randomArray);
    }

    // Merge two sorted arrays into the original array
    private static void merge(int[] leftArray, int[] rightArray, int[] OG_Array) 
    {
        int leftSize = OG_Array.length / 2;
        int rightSize = OG_Array.length - leftSize;
        int i = 0;  // index for arr (final merged array)
        int l = 0;  // index for leftArray
        int r = 0;  // index for rightArray

        // Compare and insert smaller values first
        while (l < leftSize && r < rightSize)
        {
            if (leftArray[l] < rightArray[r])
            {
                OG_Array[i] = leftArray[l];
                i++;
                l++;
            }
            else
            {
                OG_Array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        // Copy remaining elements from leftArray if any
        while (l < leftSize)
        {
            OG_Array[i] = leftArray[l];
            i++;
            l++;
        }
        // Copy remaining elements from rightArray if any
        while (r < rightSize)
        {
            OG_Array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}