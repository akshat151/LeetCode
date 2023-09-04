public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Initialize a 2D array with all elements set to 0
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill in the rest of the array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right corner contains the result
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 2;
        System.out.println(solution.uniquePaths(m, n));  // Output: 28
    }
}
