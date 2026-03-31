class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int n : nums){
            maxHeap.offer(-n);
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res = maxHeap.poll();
        }
        return res * -1;
    }
}
