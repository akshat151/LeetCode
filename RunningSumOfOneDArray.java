public class RunningSumOfOneDArray {
    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i< nums.length ;i++) {
            if(i>0){
                sum[i] = nums[i] + sum[i-1];
            } else {
                sum[i] = nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int [] ans = runningSum( new int[]{1, 2, 3, 4});
        for (int i = 0; i< ans.length ;i++) {
            System.out.println(ans[i]);
        }

    }
}
