import java.util.TreeSet;

public class LongestConsecutiveSum {
    public static int longestConsecutive(int[] nums) {
        int count = 0;
        TreeSet<Integer> t = new TreeSet<>();
        TreeSet<Integer> tCount = new TreeSet<>();
        for (int i : nums) {
            t.add(i);
        }
        if (nums.length >= 1) {
            int prev = t.first();
            for (int i : t) {
                if (prev != i) {
                    if (Math.abs(i-prev) == 1) {
                        count++;
                        prev = i;
                    } else{
                        tCount.add(count);
                        count = 0;
                        prev = i;
                    }
                }
            }
        } else {
            return 0;
        }
        tCount.add(count);
        return tCount.last() + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,3,4}));
    }
}
