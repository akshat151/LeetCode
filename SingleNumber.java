import java.util.Arrays;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static int missingNumber(int[] nums) {
        int ans = 0;
        for(int l:nums){
            ans^=l;
        }
        for(int i=0;i<=nums.length;i++){
            ans^=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1}));
    }
}
