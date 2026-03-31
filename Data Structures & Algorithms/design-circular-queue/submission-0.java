class ListNode{
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode(int v, ListNode next, ListNode prev){
            this.val = v;
            this.next = next;
            this.prev = prev;
        }
    }

class MyCircularQueue {

    public ListNode first;
    public ListNode last;
    public int space;

    public MyCircularQueue(int k) {
        space = k;
        first = new ListNode(0,null,null);
        last = new ListNode(0,null,first);
        first.next = last;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode newNode = new ListNode(value, last, last.prev);
        last.prev.next = newNode;
        last.prev = newNode;
        space--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        
        first.next = first.next.next;
        first.next.prev = first;
        space++;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : first.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : last.prev.val;
    }
    
    public boolean isEmpty() {
        return first.next == last;
    }
    
    public boolean isFull() {
        return space == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */