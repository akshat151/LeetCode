public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            boolean c = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9 && i == digits.length - 1) {
                    newDigits[i + 1] = 0;
                    digits[i] = 0;
                    c = true;
                } else if (c) {
                    if (digits[i] == 9) {
                        newDigits[i + 1] = 0;
                        digits[i] = 0;
                        c = true;
                    } else {
                        newDigits[i + 1] = ++digits[i];
                        digits[i] = digits[i];
                        c = false;
                    }
                }
            }
            if (digits[0] == 0) {
                newDigits[0] = 1;
                return newDigits;
            } else {
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        int[] j = plusOne(new int[]{9,8,9});
        System.out.println(j.toString());
    }
}
