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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reversed = reverseLinkedList(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next = reversed;
        ListNode curr = dummy;

        for (int i = 1; i < n; i++) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
        
        return reverseLinkedList(dummy.next);
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
