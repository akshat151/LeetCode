import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredictWinner {
    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Base case: the score difference when there is only one element in the array
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill the DP array diagonally
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // The optimal score difference between player 1 and player 2
        int maxScoreDiff = dp[0][n - 1];

        // Player 1 wins if the maximum score difference is non-negative or equal to zero
        return maxScoreDiff >= 0;
    }
    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1,5,233,7}));
    }
}
