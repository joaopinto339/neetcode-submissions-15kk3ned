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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftNode = dummy, curr = head;

        for(int i = 0; i < left -1; i++){
            leftNode = curr;
            curr = curr.next;
        }

        ListNode prev = null;

        for(int i = 0; i < right-left +1;i++){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        leftNode.next.next = curr;
        leftNode.next = prev;
        
        return dummy.next;
    }
}