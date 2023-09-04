import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int [] str1 = new int[26];
        for(char c: s1.toCharArray()){
            str1[c-'a']++;
        }
        int [] str2 = new int[26];
        int start = 0, end = 0, n = s1.length(), m = s2.length();
        while(end<m){
            char c = s2.charAt(end);
            str2[c-'a']++;
            while (str2[c - 'a'] > str1[c - 'a']) {
                str2[s2.charAt(start) - 'a']--;
                start++;
            }
            end++;
            if(end-start == n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
