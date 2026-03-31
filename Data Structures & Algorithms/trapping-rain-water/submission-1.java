class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];

        while(l < r){
            int sum = 0;
            if(maxLeft <= maxRight){
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                sum = maxLeft - height[l];
                if(sum > 0) res+= sum;
            }
            else{
                r--;
                maxRight = Math.max(height[r], maxRight);
                sum = maxRight - height[r];
                if(sum > 0) res += sum;
            }
        }
        return res;
    }
}
