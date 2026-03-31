class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numberSet = new HashSet<>();
        
        for(int num : nums){
            numberSet.add(num);
        }
        int count = 1;

        for(int num : numberSet){
            if(!numberSet.contains(num - 1)){
                int currentCount = 1;
                while (numberSet.contains(num + currentCount)) {
                    currentCount++;
                }
                if(currentCount > count){
                    count = currentCount;
                }
            }
        }
        return count;
    }
}
