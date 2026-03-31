class Solution {
    public int searchInsert(int[] nums, int target) {
        return dfs(nums, target,0,nums.length-1);
    }

    private int dfs(int[] nums, int target, int left, int right){
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if(nums[mid] == target) return mid;

        if(nums[mid] < target){
            return dfs(nums, target, mid+1, right);
        }
        else return dfs(nums, target, 0, mid-1);
    }
}