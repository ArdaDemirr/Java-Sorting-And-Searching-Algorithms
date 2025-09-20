/*
 *                                         JAVA INSERTION SORT
 *
 * TIME COMPLEXITY: O(N^2)
 * BEST FOR SMALL DATASETS OR NEARLY SORTED ARRAYS
 *
 * LOGIC:
 * 1. Start from the second element (index 1) because a single element (index 0) is already "sorted".
 * 2. Take the current element as the "key" to be inserted into the sorted portion.
 * 3. Compare the key with elements in the sorted portion (to its left).
 *    - Shift all elements that are greater than the key one position to the right.
 * 4. Insert the key into the correct position in the sorted portion.
 * 5. Repeat for all elements until the array is fully sorted.
 *
 * OUTER LOOP:
 * - Iterates from index 1 to the end of the array.
 * - Each iteration selects a key to insert into the sorted portion.
 *
 * INNER LOOP:
 * - Compares the key with elements before it in the sorted portion.
 * - Shifts elements greater than the key one position to the right.
 *
 * RESULT:
 * - After all iterations, the array is sorted in ascending order.
 */
public class Insertion {
    public static void main(String[] args) throws Exception 
    {
        int[] randomArray = {5,7,9,8,2,3,1,4,6};
        System.out.print("before Sorting: ");
        printArray(randomArray);
        insertionSort(randomArray);
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
    private static void insertionSort(int[] randomArray) 
    {
        // start from index 1 because a single element (index 0) is already "sorted"
        for (int i = 1;i<randomArray.length;i++)                // for every element in randomArray;
        {
            int key = randomArray[i];                           // select the current iteration as the key (temp storage)
            int j = i-1;                                        // index of the last element in the sorted part
            // shift elements greater than key one position to the right
            while (j >= 0 && randomArray[j] > key)              // while j is bigger tahn -1 (means we are not at the head of array yet) AND the element that j index indicates bigger than temp value
            {
                randomArray[j+1] = randomArray[j];              // shift it to one right
                j--;                                            // reduce the j index value in order to check all the other values until it reaches the beginning of the array
            }
            // place the key in its correct position
            randomArray[j+1] = key;                             // after while loop broken insert temp value key to the space left blank (which is j+1)
        }
    }
}