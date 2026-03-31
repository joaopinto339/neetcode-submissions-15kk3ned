class Solution {
    private static final int[][] directions = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        int islands = 0;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for(int[] d : directions){
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow >= 0 && nrow < grid.length &&
                    ncol >= 0 && ncol < grid[0].length &&
                    grid[nrow][ncol] == '1'){
                        q.offer(new int[]{nrow, ncol});
                        grid[nrow][ncol] = '0';
                    } 
            }
        }
    }
}
