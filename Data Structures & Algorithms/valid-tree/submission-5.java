class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        for(int[] e : edges){
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k-> new ArrayList<>()).add(e[0]);
        }

        if(!dfs(0,-1)) return false;
        return cycle.size() == n;
    }

    private boolean dfs(int node, int parent){
        if(cycle.contains(node)) return false;
        cycle.add(node);
        for(int e : map.getOrDefault(node, new ArrayList<>())){
            if(e != parent && !dfs(e, node)) return false;
        }
        return true;
    }
}
