class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> streakStarters = new HashSet<>();
        
        for(int num : nums){
            numbers.add(num);
        }

        for(int num : numbers){
            if(!numbers.contains(num-1)){
                streakStarters.add(num);
            }
        }
        int count = 1;

        for(int starter : streakStarters){
            int currentCount = 1;
            for(int i = starter + 1; ; i++){
                if(numbers.contains(i)){
                    currentCount++;
                }
                else{
                    break;
                }
            }
            if(currentCount > count){
                count = currentCount;
            }
        }
        return count;
    }
}
