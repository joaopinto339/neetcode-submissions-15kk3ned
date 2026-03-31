class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> values = new HashSet<Integer>();
        for(int num : nums){
            if(values.contains(num)){
                return true;
            }
            values.add(num);
        }
        return false;
    }
}