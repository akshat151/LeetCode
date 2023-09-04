public class MinimumStringLengthAfterRemovingSubstring {
    public static int minLength(String s) {
        StringBuilder b = new StringBuilder(s);
        String a = "AB";
        String c = "CD";
        int i = 0;
        int j = 2;
        while(b.capacity()>=2) {
            if(b.toString().contains(a) || b.toString().contains(c)) {
                if(j<=b.length()) {
                    String temp = b.substring(i, j);
                    if(temp.equals(a) || temp.equals(c)) {
                        b = new StringBuilder(b.substring(i+2, b.length()));
                        i = 0;
                        j = 2;
                    } else {
                        i = j;
                        j = i + 2;
                    }
                }

            } else{
                return b.length();
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int ans = minLength("ABFGCDGH");
        System.out.println(ans);
    }
}
