import java.util.HashSet;
import java.util.Set;

public class MaximumDistinct {
    public static int getMaximumDistinctCount(int[] a, int[] b, int k) {
        Set<Integer> aSet = new HashSet<>();
        for (int i : a) {
            aSet.add(i);
        }
        if (aSet.size() < a.length) {
            int itemToSwap = a.length - aSet.size();
            if (k <= itemToSwap) {
                itemToSwap = k;
            } else {
                itemToSwap = k - itemToSwap;
            }
            for (int j : b) {
                if (itemToSwap > 0) {
                    if (aSet.add(j)) {
                        itemToSwap--;
                    }
                } else {
                    return aSet.size();
                }
            }
        } else {
            return a.length;
        }
        return aSet.size();
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 2, 2, 2};
        int[] b = {2, 2, 2, 2, 2};
        int result = getMaximumDistinctCount(a, b, 1);
        System.out.println(result); // Output should be 4
    }
}
