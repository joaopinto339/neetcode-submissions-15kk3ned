class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap();
        for(int n : nums){
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> counts.get(n1) - counts.get(n2)
        );

        for (int num : counts.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.stream().mapToInt(i -> i).toArray();
    }
}
