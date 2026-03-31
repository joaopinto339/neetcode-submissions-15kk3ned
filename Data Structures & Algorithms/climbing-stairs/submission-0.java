class Solution {
    private int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for(int i = 0; i < n; i++){
            cache[i] = -1;
        }
        return dfs(0, n);
    }

    private int dfs(int step, int target){
        if(step >= target) return step == target ? 1 : 0;
        if(cache[step] != -1) return cache[step];
        return cache[step] = dfs(step + 1, target) + dfs(step + 2, target);
    }
}
