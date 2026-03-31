class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;

        while(l < r){
            if(numbers[l] + numbers[r] == target){
                break;
            }
            if(numbers[l] + numbers[r] > target){
                r--;
                continue;
            }
            if(numbers[l] + numbers[r] < target){
                l++;
                continue;
            }
        }
        return new int[]{l+1, r+1};
    }
}
