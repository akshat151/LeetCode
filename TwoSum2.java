import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
      int [] ans = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            if(!m.containsKey(target-numbers[i])){
                m.put(numbers[i], i);
            } else {
                ans[1] = i +1 ;
                ans[0] = m.get(target - numbers[i])+1;
            }
        }
      return ans;
    }

    public static void main(String[] args) {
        int[] j = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(j);
    }
}
