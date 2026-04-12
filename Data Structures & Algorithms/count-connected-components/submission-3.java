class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for(int[] e : edges){
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        int connected = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i);
                connected++;
            }
        }
        return connected;
    }

    private void dfs(int node){
        visited.add(node);
        for(int child : map.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(child)){
                dfs(child);
            }
        }
    }
}
