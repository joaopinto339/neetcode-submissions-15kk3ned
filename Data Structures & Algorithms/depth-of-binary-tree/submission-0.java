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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int count = 1;
        int left = countDepth(root.left, count);
        int right = countDepth(root.right, count);

        return Math.max(left, right);
    }

    private int countDepth(TreeNode root, int curr){
        if(root == null) return curr;
        curr = curr + 1;
        int left = countDepth(root.left, curr);
        int right = countDepth(root.right, curr);
        return Math.max(left, right);
    }
}
