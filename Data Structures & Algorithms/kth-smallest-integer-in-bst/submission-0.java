/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> values = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        dfs(root.left);
        values.add(root.val);
        if(values.size() >= k){
            return values.get(k-1);
        }
        dfs(root.right);
        return values.get(k-1);
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);
        values.add(node.val);
        dfs(node.right);
    }
}
