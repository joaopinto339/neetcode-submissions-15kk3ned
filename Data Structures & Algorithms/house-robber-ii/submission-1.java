class Solution {
    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        memo1 = new int[nums.length];
        memo2 = new int[nums.length];

        for(int i = 0; i < memo1.length; i++){
            memo1[i] = -1;
            memo2[i] = -1;
        }
        int first = dfs(nums, 0, nums.length - 1, memo1);
        int sec = dfs(nums, 1, nums.length, memo2);
        
        return Math.max(first, sec);
    }

    private int dfs(int[] nums, int i, int end, int[] memo){
        if(i >= end) return 0;
        if(memo[i] != -1) return memo[i];

        memo[i] = Math.max(dfs(nums, i+1, end, memo), 
            nums[i] + dfs(nums, i+2, end, memo));
        
        return memo[i];
    }   
}
