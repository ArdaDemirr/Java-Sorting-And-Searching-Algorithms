/*
 * JAVA RECURSIVE GRID FILLING
 *
 * TIME COMPLEXITY: O(4^n)
 * - Where 'n' is the input power. The total number of cells is (2^n * 2^n) = 4^n.
 * - We visit every cell exactly once.
 *
 * SPACE COMPLEXITY: O(4^n)
 * - The 2D array requires storage for all generated numbers.
 * - Recursion stack depth is O(n).
 *
 * LOGIC:
 * 1. Calculate Grid Size:
 * - The grid dimensions are determined by 2^n (calculated using bitwise shift 1<<n).
 * 2. Divide and Conquer (Recursion):
 * - The grid is split into 4 smaller quadrants of size 2^(n-1).
 * - This continues until n=0 (base case), which represents a single 1x1 cell.
 * 3. Quadrant Value Assignment:
 * - Determine the number of elements in a quadrant (halfsize * halfsize).
 * - Assign starting values to quadrants in a specific order to create the pattern:
 * a. Top-Right quadrant gets the smallest values (startingValue + 0).
 * b. Bottom-Right quadrant gets the next range (startingValue + 1 * count).
 * c. Bottom-Left quadrant gets the next range (startingValue + 2 * count).
 * d. Top-Left quadrant gets the highest values (startingValue + 3 * count).
 * 4. Fill:
 * - Recursively call the function for each quadrant with adjusted coordinates and values.
 *
 * RESULT:
 * - Generates a specific fractal-like traversal path (similar to a Hilbert or Z-order curve variation).
 */

import java.util.Scanner;

public class FillAGrid {
    public static void main(String[] args) {

        // Initialize input scanner
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter the n value: ");

        // Read n from user (e.g., if n=2, grid is 4x4)
        int n = kb.nextInt();
        System.out.println();
        kb.close();

        // Generate the grid using the recursive function
        int[][] result = specialgrid(n);

        // Print the 2D array to console
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                // Print value with a tab for alignment
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();   // Move to next line after printing a row
        }
    }

    public static int[][] specialgrid(int n) {
        // Calculate size using bitwise shift (1 << n is equivalent to 2^n)
        int size = 1<<n;

        // Allocate memory for the grid
        int[][] result = new int[size][size];

        // Start the recursive filling process
        // (0,0) is the top-left start coordinate, 0 is the initial value
        fill(result,0,0,n,0);
        return result;
    }

    public static void fill(int[][] result, int row, int col, int n, int startingValue) {
        // Base Case: When n becomes 0, we are at a single cell (1x1)
        if (n == 0)
        {
            result[row][col] = startingValue;
            return;
        }

        // Calculate dimensions for the next level of recursion
        int next_n = n-1;
        int halfsize = 1<<next_n;
        int quadrantNum = halfsize*halfsize;

        // Recursive calls for the 4 quadrants.
        // Note: The logical order of values (Lowest to Highest) is:
        // 1. Top-Right  (offset: 0)
        // 2. Bottom-Right (offset: 1 * quadrantNum)
        // 3. Bottom-Left  (offset: 2 * quadrantNum)
        // 4. Top-Left     (offset: 3 * quadrantNum)

        // 1. Fill Top-Left (Physical Position) -> gets Highest Values
        fill(result, row, col, next_n, startingValue+(3*quadrantNum) );

        // 2. Fill Bottom-Left (Physical Position) -> gets 2nd Highest Values
        fill(result, row+halfsize, col, next_n, startingValue+(2*quadrantNum) );

        // 3. Fill Top-Right (Physical Position) -> gets Lowest Values (Base startingValue)
        fill(result, row, col+halfsize, next_n, startingValue);

        // 4. Fill Bottom-Right (Physical Position) -> gets 2nd Lowest Values
        fill(result, row+halfsize, col+halfsize, next_n, startingValue+quadrantNum );
    }
}