class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sums = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length-1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums [r];
                if(sum > 0 ){
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    List<Integer> tmp = Arrays.asList(nums[i], nums[l], nums[r]);
                    sums.add(tmp);
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(sums);
    }
}
