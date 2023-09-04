import java.util.*;
import java.util.List;
/*
Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] h = str.toCharArray();
            Arrays.sort(h);
            String r = String.valueOf(h);
            List<String> values1 = map.get(r);
            if (values1 == null) {
                values1 = new ArrayList<>();
                map.put(r, values1);
                values1.add(str);
            } else {
                values1.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        List<List<String>> ans = groupAnagrams( new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(ans.toString());
    }
}
