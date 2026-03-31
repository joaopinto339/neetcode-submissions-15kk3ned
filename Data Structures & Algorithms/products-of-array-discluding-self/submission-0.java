class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> mapped = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mapped.put(i, nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int prod = 1;
            for(int j = 0; j < mapped.size(); j++){
                if(j != i){
                    prod *= mapped.get(j);
                }
            }
            res[i] = prod;
        }
        return res;
    }
}  
