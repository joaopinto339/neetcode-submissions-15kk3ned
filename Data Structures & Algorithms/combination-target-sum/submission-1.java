class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if(nums.length < 1) return res;
        dfs(nums, 0, 0, target, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, int count, int target, List<Integer> subset, List<List<Integer>> res){
        if(i >= nums.length || count > target){
            return;
        }

        if(count == target){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i, count + nums[i], target, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, count, target, subset, res);
    }
}
