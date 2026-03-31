class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : count){
            if(c > 0) maxHeap.add(c);
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }
            else{
                int remainingProcesses = maxHeap.poll() - 1;
                if(remainingProcesses > 0){
                    q.add(new int[]{remainingProcesses, time+n});
                }
            }
            
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
