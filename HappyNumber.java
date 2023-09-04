import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            int sum = 0;
            while(n>0){
                int prod = n%10;
                sum += prod * prod;
                n = n/10;
            }
            n = sum;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
