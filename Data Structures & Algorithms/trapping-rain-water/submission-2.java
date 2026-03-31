class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];

        while(l < r){
            if(maxLeft <= maxRight){
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                res += maxLeft - height[l];
            }
            else{
                r--;
                maxRight = Math.max(height[r], maxRight);
                res += maxRight - height[r];
            }
        }
        return res;
    }
}
