// your code starts here
import java.util.Scanner;
// main class
public class Main {
    public static void main(String[] args)
    {
        // creating scanner object
        Scanner sc = new Scanner(System.in);
        // accepting number of rows and columns
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        // accepting the elements of the matrix
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j< m; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        // find the largest element in a row and the smallest element in a column
        int maxInRow, minInCol;
        boolean found = false;
        for(int i = 0; i < n; i++)
        {
            // assigning default min value to maxInRow
            maxInRow = Integer.MIN_VALUE;
            // assigning default max value to minInCol
            minInCol = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++)
            {
                // find the maximum element in the row
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                }
                // check if the element is the smallest in its column
                if(i == 0 || matrix[i][j] < minInCol)
                {
                    // assign the element at index i,j to minInCol
                    minInCol = matrix[i][j];
                    // check if the element is the smallest in the entire column
                    for(int k = 0; k < n; k++)
                    {
                        if (matrix[k][j] < minInCol)
                        {
                            // break the loop
                            break;
                        }
                        // check if k is equal to n-1
                        if (k == n - 1) {
                            // assign true to found
                            found = true;
                        }
                    }
                }
            }
            // print the element if it is the largest in the row and the smallest in the column
            if (found && maxInRow == minInCol) {
                System.out.println(maxInRow);
                return;
            }
        }
        // if no such element is found, print -1
        System.out.println("-1");
    }
}