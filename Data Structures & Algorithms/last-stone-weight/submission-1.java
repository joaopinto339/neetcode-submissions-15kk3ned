class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if(s1 - s2 > 0){
                maxHeap.add(s1 - s2);
            }
        }
        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}
