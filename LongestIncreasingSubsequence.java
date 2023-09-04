public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequenceCounter(char[] X) {
        int min_ord = 100;
        for (char c : X) {
            min_ord = Math.min(min_ord, (int) c);
        }
        int[] dp = new int[('z' - min_ord) + 1];
        int longestSubsequenceLength = Integer.MIN_VALUE;
        for (char x : X) {
            int position = (int) x - min_ord;
            int current_char_len = 0;
            for (int j = 0; j < position; j++) {
                current_char_len = Math.max(current_char_len, dp[j]);
            }
            current_char_len += 1;
            longestSubsequenceLength = Math.max(longestSubsequenceLength, current_char_len);
            dp[position] = Math.max(dp[position], current_char_len);
        }
        // Return the length of Longest Increasing Subsequence
        return longestSubsequenceLength;
    }

    public static void main(String[] args) {
        char[] X = "0123456789".toCharArray();
        System.out.println(longestIncreasingSubsequenceCounter(X));
    }
}
