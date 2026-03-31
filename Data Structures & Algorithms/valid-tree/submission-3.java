class Solution {
    private Map<Integer, List<Integer>> edgesMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        for(int i = 0; i < n; i++){
            edgesMap.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            edgesMap.get(e[0]).add(e[1]);
            edgesMap.get(e[1]).add(e[0]);
        }
        if(!dfs(0,-1)) return false;

        return visiting.size() == n;
    }

    private boolean dfs(int curr, int from){
        if(visiting.contains(curr)) return false;

        visiting.add(curr);
        for(int e : edgesMap.get(curr)){
            if(e == from) continue;
            if(!dfs(e, curr)) return false;
        }
        return true;
    }
}
