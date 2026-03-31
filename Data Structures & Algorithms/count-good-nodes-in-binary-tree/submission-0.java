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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        
        if(root == null) return count;
        count += 1;

        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return count;
    }

    private void dfs(TreeNode leaf, int rootVal){
        if(leaf == null) return;

        int currMax = rootVal;
        if(leaf.val >= rootVal){
            count++;
            currMax = leaf.val;
        }
        
        dfs(leaf.left, currMax);
        dfs(leaf.right, currMax);
    }



}
