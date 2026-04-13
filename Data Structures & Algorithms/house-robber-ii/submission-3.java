class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3){
            int max = Math.max(nums[0], nums[1]);
            return max > nums[2] ? max : nums[2];
        } 

        int[] firstHouse = new int[n-1];
        firstHouse[0] = nums[0];
        firstHouse[1] = Math.max(nums[0],nums[1]);

        int[] lastHouse = new int[n-1];
        lastHouse[0] = nums[1];
        lastHouse[1] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < n - 1; i++){
            firstHouse[i] = Math.max(nums[i] + firstHouse[i-2], firstHouse[i-1]);
            lastHouse[i] = Math.max(nums[i+1] + lastHouse[i-2], lastHouse[i-1]);
        }

        return Math.max(firstHouse[n-2], lastHouse[n-2]);
    }
}
