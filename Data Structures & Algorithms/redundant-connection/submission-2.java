class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited;

    public int[] findRedundantConnection(int[][] edges) {

        for(int[] e : edges){
            int u = e[0], v = e[1];
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
            visited = new HashSet<>();
            if(dfs(u, -1)){
                return e;
            }
        }

        return new int[]{};
    }

    private boolean dfs(int node, int parent){
        if(visited.contains(node)) return true;

        visited.add(node);

        for(int c : map.getOrDefault(node, new ArrayList<>())){
            if(c == parent){
                continue;
            }
            if(dfs(c, node)){
                return true;
            }
        }
        return false;
    }
}
