/*
 *                                          JAVA BUBBLE SORT
 *
 * TIME COMPLEXITY: O(N^2)
 * BEST FOR SMALL DATASETS
 *
 * LOGIC:
 * 1. Compare each element with the next one in the array.
 *    - If the current element is bigger than the next, swap them.
 * 2. Outer loop:
 *    - Iterates from index 0 to the last element.
 *    - Controls the number of passes through the array.
 * 3. Inner loop:
 *    - Iterates from index 0 to (array length - outer index - 1).
 *    - The "- outer index - 1" part avoids already sorted elements at the end.
 * 4. Each pass "bubbles" the largest unsorted element to its correct position at the end.
 * 5. Repeat until all elements are in order.
 *
 * RESULT:
 * - After all passes, the array is sorted in ascending order.
 */
public class bubbleSort {
    public static void main(String[] args) throws Exception 
    {
        int[] randomArray = {5,7,9,8,2,3,1,4,6};
        System.out.print("before Sorting: ");
        printArray(randomArray);
        bubbleSort(randomArray);
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
    private static void bubbleSort(int[] randomArray) 
    {
        // Outer loop runs for each element except the last
        for (int i = 0 ; i < randomArray.length - 1 ; i++)                // for every element in randomArray;
        {
            // Inner loop compares adjacent elements up to the last unsorted element
            for(int j = 0 ; j < randomArray.length - i - 1 ; j++)         // it is length - i - 1 because after every iteration we push the biggest ones to the end so no need to check ends anymore 
            {
                // If current element is greater than the next, swap them
                if(randomArray[j] > randomArray[j + 1])
                {
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j + 1];
                    randomArray[j + 1] = temp;
                }
            }
        }
    }
}