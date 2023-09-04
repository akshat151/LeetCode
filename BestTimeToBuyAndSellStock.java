import java.util.HashMap;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int ans = maxProfit( new int[]{886,729,539,474,5,653,588,198,313,111,38,808,848,364,819,747,520,568,583,253,605,442,779,903,217,284,927,33,859,75,418,612,174,316,167,40,945,740,174,279,985,133,38,919,528,844,101,291,673,561,244,827,602,58,777,625,95,563,102,400,921,988,472,629,781,215,7,131,220,147,841,511,201,558,435,802,995,514,83,618,399,542,352,34,943,983,498,20,235,156,768,23});
        System.out.println(ans);
    }
}
