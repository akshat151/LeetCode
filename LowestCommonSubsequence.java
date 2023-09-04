public class LowestCommonSubsequence {
    public static int longestCommonSubsequenceDP(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[] dp = new int[m+1];
        int[] prev_dp;
        for (int i = 1; i <= n; i++) {
            prev_dp = dp.clone();
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[j] = prev_dp[j-1] + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], prev_dp[j]);
                }
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceDP("", ""));
    }
}
