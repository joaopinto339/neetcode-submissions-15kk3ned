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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode rightMost = null;
            int qLength = q.size();
            for(int i = 0; i < qLength; i++){
                TreeNode node = q.poll();
                if(node != null){
                    rightMost = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightMost != null){
                res.add(rightMost.val);
            }
        }
        return res;
    }
}
