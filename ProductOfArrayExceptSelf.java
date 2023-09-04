import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] prefixProd = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            if(i!=0){
                product = product * nums[i-1];
            }
            prefixProd[i] = product;
        }
        product = 1;
        for(int j = nums.length-1; j>=0; j--){
            if(j != nums.length-1){
                product = product * nums[j+1];
                prefixProd[j] = prefixProd[j] * product;
            }
        }
        return prefixProd;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
