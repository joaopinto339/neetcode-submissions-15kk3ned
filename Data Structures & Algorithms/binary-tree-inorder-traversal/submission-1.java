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
    List<Integer> nodes;
    public List<Integer> inorderTraversal(TreeNode root) {
        nodes = new ArrayList<>();
        dfs(root);
        return nodes;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        nodes.add(root.val);
        dfs(root.right);
    }
}