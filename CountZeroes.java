
public class CountZeroes {
    public static void main(String[] args) {
        int[] a = {20, 11, 10, 10070, 7};
        int result = solution(a);
        System.out.println(result); // Output should be 3
    }

    public static int solution(int[] a) {
        int count = 0;

        for (int num : a) {
            if (hasOddZeroOccurrences(num)) {
                count++;
            }
        }

        return count;
    }

    public static boolean hasOddZeroOccurrences(int num) {
        int digitCount = 0;
        while (num > 0) {
            if (num % 10 == 0) {
                digitCount++;
            }
            num /= 10;
        }
        return digitCount % 2 == 1;
    }
}
