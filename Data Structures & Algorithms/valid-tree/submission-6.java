class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        for(int[] e : edges){
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k-> new ArrayList<>()).add(e[0]);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,-1});

        while(!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                int[] node = q.poll();
                int child = node[0], parent = node[1];
                if(visited.contains(child)) return false;
                visited.add(child);
                for(int e : map.getOrDefault(child, new ArrayList<>())){
                    if(e != parent){
                        q.add(new int[]{e, child});
                    }
                }
            }
        }
        return visited.size() == n;
    }
}
