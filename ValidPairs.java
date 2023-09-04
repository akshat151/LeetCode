import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPairs {

    // Function to find valid pairs
    private static boolean checkValidity(String location) {
        int len = location.length();

        // Basic structural checks
        if (location.charAt(0) != '(' || location.charAt(len-1) != ')' || location.contains(" ")) {
            return false;
        }

        int commaPos = location.indexOf(',');
        if (commaPos == -1) {
            return false;
        }

        // Check for signs
        int i = 1;
        if (location.charAt(i) == '+' || location.charAt(i) == '-') {
            i++;
        }

        int j = commaPos + 1;
        if (location.charAt(j) == '+' || location.charAt(j) == '-') {
            j++;
        }

        String x = location.substring(i, commaPos);
        String y = location.substring(j, len-1);

        // Check for leading zeros
        if ((x.length() > 1 && x.charAt(0) == '0' && x.charAt(1) != '.') ||
                (y.length() > 1 && y.charAt(0) == '0' && y.charAt(1) != '.')) {
            return false;
        }

        try {
            double lat = Double.parseDouble(x);
            double lon = Double.parseDouble(y);

            if ((lat < -90 || lat > 90) || (lon < -180 || lon > 180)) {
                return false;
            }
        } catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputStrSize = scanner.nextInt();
        scanner.nextLine();

        String temp = scanner.nextLine();

        boolean result = checkValidity(temp);

       System.out.println(result);

        scanner.close();
    }
}
