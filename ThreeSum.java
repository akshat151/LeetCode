import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate values for the first element
            }
            int target = - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(k < nums.length - 1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                if(nums[j]+nums[k]==target) {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if(nums[j]+nums[k]<target){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> j = threeSum(new int[]{-2,0,1,1,2});
        System.out.println(j.toString());
    }
}
