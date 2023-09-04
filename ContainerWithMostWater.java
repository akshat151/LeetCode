public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int r = height.length-1;
        int l = 0;

        while(l<r){
            maxArea = Math.max(maxArea, Math.min(height[r], height[l]) * (r-l));
            if(height[l]<height[r]){
                l++;
            } else{
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int j = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(j);
    }
}
