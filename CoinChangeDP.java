import java.util.Arrays;

public class CoinChangeDP {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);

        for (int k : coins) {
            for(int i = k;i<=amount;i++){
                if (i - k >= 0 ) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - k]);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int j = coinChange(new int[]{2}, 3);
        System.out.println(j);
    }
}
