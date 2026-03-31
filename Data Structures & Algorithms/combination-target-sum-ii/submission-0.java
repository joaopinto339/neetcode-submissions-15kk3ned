class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int target, int i, List<Integer> subset){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i == nums.length) return;

        subset.add(nums[i]);
        dfs(nums, target - nums[i], i + 1, subset);
        subset.remove(subset.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        dfs(nums, target, i+1, subset);
    }
}
