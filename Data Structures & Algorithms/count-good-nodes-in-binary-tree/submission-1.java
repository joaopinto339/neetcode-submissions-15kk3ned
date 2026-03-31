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
    public int goodNodes(TreeNode root) { 
        if(root == null) return 0;
        return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
    }

    private int dfs(TreeNode leaf, int rootVal){
        if(leaf == null) return 0;

        int currMax = rootVal;
        if(leaf.val >= rootVal){
            currMax = leaf.val;
            return 1 + dfs(leaf.left, currMax) + dfs(leaf.right, currMax);
        }        
        else{
            return  dfs(leaf.left, currMax) + dfs(leaf.right, currMax);
        }
    }
}
