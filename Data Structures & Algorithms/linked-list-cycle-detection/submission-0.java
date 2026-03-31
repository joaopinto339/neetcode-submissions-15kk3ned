/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode curr = head;

        while(curr != null){
            if(nodes.contains(curr.next)){
                return true;
            }
            else{
                nodes.add(curr.next);
            }
            curr = curr.next;
        }
        return false;
    }
}
