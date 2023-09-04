import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a, b)
        -> b.getValue() - a.getValue());
        maxHeap.addAll(m.entrySet());
        int[] ans = new int[k];
        for(int i = 0;i< ans.length ; i++){
            ans[i] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }
//        List<Integer> j = new ArrayList<Integer>(m.values());
//        j.sort(Collections.reverseOrder());
//        int[] ans = new int[k];
//        for(int i = 0 ;i< ans.length;i++) {
//            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
//                if (entry.getValue().equals(j.get(i))) {
//                    ans[i] = entry.getKey();
//                    m.remove(entry.getKey());
//                    break;
//                }
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int[] ans = topKFrequent(new int[]{1, 2}, 2);
        System.out.println(ans);
    }
}
