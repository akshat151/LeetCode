public class MergeSortedArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return nums1;
        }
        int i = 0,j = 0;
        if(m>0){
            i = m - 1;
        }
        if(n>0){
            j = n - 1;
        }
        int k = nums1.length - 1;

        while(k>=0 && (i>=0 && j>=0)){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        int[] j = merge(new int[]{2,0},1, new int[]{1}, 1);
        for(int i: j){
            System.out.println(String.valueOf(i));
        }
    }
}
