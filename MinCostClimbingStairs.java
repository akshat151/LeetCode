public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int [] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<len; i++){
            dp[i] = cost[i]+ Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[len-1],dp[len-2]);
    }
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {10,15}));
    }
}
