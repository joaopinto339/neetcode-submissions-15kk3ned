class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int r = 0; r < m; r++){
            pacQueue.add(new int[]{r,0});
            atlQueue.add(new int[]{r, n-1});
        }
        for(int c = 0; c < n; c++){
            pacQueue.add(new int[]{0, c});
            atlQueue.add(new int[]{m-1, c});
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];
            ocean[r][c] = true;
            for(int[] dir : directions){
                int row = r + dir[0];
                int col = c + dir[1];
                if(row >= 0 && row < m && col >= 0 && col < n && 
                    !ocean[row][col] && heights[row][col] >= heights[r][c]){
                        q.add(new int[]{row,col});
                }
            }
        }
    }
}
