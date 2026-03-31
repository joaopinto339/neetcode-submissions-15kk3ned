class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }
            map.put(n, map.get(n)+1);
            if(map.get(n) > max){
                max = n;
            }
        }
        return max;
    }
}
