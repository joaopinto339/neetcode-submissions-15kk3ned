class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[i] = 1;
            }
            else{
                res[i] = res[i-1] * nums[i-1];
            }
        }
        int postfix = 1;
        for(int i = nums.length-1; i >= 0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
        
    }
}  
