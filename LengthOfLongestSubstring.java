import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int l = 0;
        Map<Character,Integer> m = new HashMap<>();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(m.containsKey(c)){
                l = Math.max(l, m.get(c) + 1);
            }
            m.put(c,i);
            maxLength = Math.max(maxLength, i - l + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
