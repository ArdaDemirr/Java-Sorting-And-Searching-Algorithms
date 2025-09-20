/*
 *                                         JAVA SELECTION SORT
 *
 * TIME COMPLEXITY: O(N^2)
 * BEST FOR SMALL DATASETS
 *
 * LOGIC:
 * 1. Start with the first element of the array and assume it is the minimum.
 * 2. Compare this element with all other elements to find the true minimum in the unsorted portion.
 * 3. If a smaller element is found, update the minimum index.
 * 4. After checking all elements, swap the minimum element with the current position of the outer loop.
 * 5. Repeat the process for the next index until the array is fully sorted.
 *
 * OUTER LOOP:
 * - Iterates from index 0 to the second-to-last element.
 * - Each iteration assumes the current element is the minimum.
 *
 * INNER LOOP:
 * - Starts at index (outer index + 1) and goes to the end of the array.
 * - Compares each element with the current minimum and updates the minimum index if a smaller element is found.
 *
 * SWAP:
 * - After the inner loop, the minimum element is placed at the outer loop's index.
 * - The original value at the outer loop's index moves to the position of the minimum element.
 */
public class Selection {
    public static void main(String[] args) throws Exception 
    {
        int[] randomArray = {5,7,9,8,2,3,1,4,6};
        System.out.print("before Sorting: ");
        printArray(randomArray);
        selectionSort(randomArray);
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
    private static void selectionSort(int[] randomArray) 
    {
        // loop through each position except the last one
        for (int i = 0;i<randomArray.length-1;i++)              // for every element in randomArray;
        {
            int minIdx = i;                                     // assume the current position holds the smallest element
            // search for a smaller element in the rest of the array
            for(int j = i+1;j<randomArray.length;j++)           // for every other elements after the i 
            {
                if (randomArray[j] < randomArray[minIdx])       // compare them with the one that we declare as minimum if found a new minimum
                {
                    minIdx = j;                                 // update index of the new minimum
                }
            }
            // swap the smallest element found with the element at position i
            int temp = randomArray[i];                          // after finding the minimum index, temp store the first value that we declared at the beginning
            randomArray[i] = randomArray[minIdx];               // put the real minimum value to the indicated index [i]
            randomArray[minIdx] = temp;                         // put the temp value to the place that we found the minimum before
        }
    }                                                           // now loop this process with the one right element
}