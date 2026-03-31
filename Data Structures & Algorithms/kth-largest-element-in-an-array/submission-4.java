class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kIndex = nums.length - k;

        return quickSelect(0, nums.length-1, nums, kIndex);
    }

    private int quickSelect(int left, int right, int[] nums, int k){
        int pivot = nums[right];
        int pointer = left;

        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                int tmp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = tmp;
                pointer++;
            }
        }
        int tmp = nums[pointer];
        nums[pointer] = pivot;
        nums[right] = tmp;

        if(pointer > k) return quickSelect(left, pointer-1, nums, k);
        else if(pointer < k) return quickSelect(pointer+1, right, nums, k);
        else return nums[pointer];
    }
}
