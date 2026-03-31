class Solution {
    Set<Integer> visitedNodes = new HashSet<Integer>();
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visitedNodes.contains(i)){
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node){
        visitedNodes.add(node);

        for(int nei : adj.get(node)){
            if(!visitedNodes.contains(nei)){
                dfs(nei);
            }
        }

    }
}
