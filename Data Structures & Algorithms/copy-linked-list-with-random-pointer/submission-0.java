/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mappedNodes = new HashMap<>();
        
        mappedNodes.put(null, null);
        Node curr = head;

        while(curr != null){
            Node newNode = new Node(curr.val);
            mappedNodes.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = mappedNodes.get(curr);
            copy.next = mappedNodes.get(curr.next);
            copy.random = mappedNodes.get(curr.random);
            curr = curr.next;
        } 

        return mappedNodes.get(head);
        
    }
}
