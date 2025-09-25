public class MergeSort2 {

    // merge function
    public static void merge(int[] A, int left, int mid, int right) {
        //calculate new left and right subarray sizes
        int n1 = mid - left + 1;    // +1 because it includes mid too.
        int n2 = right - mid;

        // declare new left and right subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // populate left subarray - use left + i to correct indexing
        for (int i = 0; i < n1; i++) {
            L[i] = A[left + i];
        }
        // populate right subarray - use mid + 1 + i to correct indexing
        for (int j = 0; j < n2; j++) {
            R[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;     // k is left because it represents first index place of the current subarray
        while (i < n1 && j < n2) {      // while neither of the loop counters exceed capacity of subarrays:
            if (L[i] <= R[j]) {         // check if the current value of the left subarray less or equal to the current value of the right subarrays
                A[k] = L[i];            // if it is add left subarrays value to the main array
                i++;                    // increment left subarrays counter
            } else {                    // if not less than:
                A[k] = R[j];            // add right subarrays value to the main array
                j++;                    // increment right arrays counter
            }
            k++;                        // after if else block increment main arrays loop counter
        }

        // copy remaining
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    // recursive merge sort
    public static void mergeSort(int[] A, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A, mid + 1, right);
        merge(A, left, mid, right);
    }

    // driver
    public static void main(String[] args) {
        int[] A = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(A, 0, A.length - 1);

        System.out.print("Sorted array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}