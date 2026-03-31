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
        if(root == null) return nodes;
        dfs(root.left, nodes);
        nodes.add(root.val);
        dfs(root.right, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes){
        if(root == null) return;
        if(root.left == null && root.right == null){
            nodes.add(root.val);
        }
        else{
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }
}