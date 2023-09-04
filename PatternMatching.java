public class PatternMatching {
    public static boolean isMatch(String s, String p) {
        boolean result = true;
        int len = s.length() - 1;
        int lenP = p.length() - 1;
        char star = '*';
        char dot = '.';
        char lastPattern = '?';
        char lastChar = '%';

        while(len>=0){
            if(lenP>=0){
                if(p.charAt(lenP) != star && p.charAt(lenP) != dot && lastChar != '%'){
                    if(s.charAt(len) != p.charAt(lenP)){
                        return false;
                    }
                } else if(p.charAt(lenP) == star && p.charAt(lenP) != dot && lastPattern != star){
                    lastPattern = star;
                } else if(p.charAt(lenP) != star && p.charAt(lenP) != dot && lastPattern == star){
                    lastChar = p.charAt(lenP);
                } else if(p.charAt(lenP) != star && p.charAt(lenP) != dot && lastChar == '%'){
                    if(s.charAt(len) != p.charAt(lenP)){
                        return false;
                    }
                }
                lenP--;
            } else if(p.length()>=2){
                if(lastPattern == star && lastChar != '%'){
                    if(s.charAt(len) != lastChar){
                        return false;
                    }
                }else {
                    return false;
                }
            } else {
                return false;
            }
            len--;
        }
        if(lenP>=0){
            return false;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}