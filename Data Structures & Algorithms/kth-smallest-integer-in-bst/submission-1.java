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
    private int index;
    private int count;
    private int smallestKthVal;

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        count = 0;
        smallestKthVal = 0;
        if(root == null) return 0;
        dfs(root);
        return smallestKthVal;
    }

    private void dfs(TreeNode node){
        if(node == null || count == index) return;

        dfs(node.left);
        if(count < index){
            smallestKthVal = node.val;
            count++;
        }
        dfs(node.right);
    }
}
