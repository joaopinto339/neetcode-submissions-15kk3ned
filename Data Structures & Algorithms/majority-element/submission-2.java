class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length < 2) return nums[0];
        Arrays.sort(nums);
        int i = nums.length / 2;
        return nums[i];
    }
}