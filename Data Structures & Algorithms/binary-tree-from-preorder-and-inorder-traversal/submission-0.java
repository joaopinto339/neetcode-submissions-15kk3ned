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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i = 0; i < preorder.length; i++){
            if(preorder[0] == inorder[i]){
                mid = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);

        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);

        return node;
    }
}
