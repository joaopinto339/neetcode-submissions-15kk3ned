class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;

        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                break;
            }
            if(sum > target){
                r--;
                continue;
            }
            if(sum < target){
                l++;
                continue;
            }
        }
        return new int[]{l+1, r+1};
    }
}
