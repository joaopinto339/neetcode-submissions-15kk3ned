class Solution {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(nums[j] == val){
                j++;
                if(j >= nums.length) return res;
            }
            if(j != i){
                nums[i] = nums[j];
                nums[j] = val;
            }
            res++;
        }
        return res;
    }
}