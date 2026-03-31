class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1; //anything times 1 is anything;
        int res = nums[0];          //so far

        for(int n : nums){
            int tmp = curMax * n;
            curMax = Math.max(Math.max(tmp, curMin * n), n);
            curMin = Math.min(Math.min(tmp, curMin * n), n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
