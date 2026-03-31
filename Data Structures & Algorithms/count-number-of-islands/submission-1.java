class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c] = '0';

        while(!q.isEmpty()){
            int[] coor = q.poll();
            int row = coor[0], col = coor[1];

            for(int[] d : directions){
                int nRow = row + d[0];
                int nCol = col + d[1];
                if(nRow >= 0 && nRow < grid.length &&
                    nCol >= 0 && nCol < grid[0].length &&
                    grid[nRow][nCol] == '1'){
                        q.offer(new int[]{nRow,nCol});
                        grid[nRow][nCol] = '0';
                    }
            }
        }
    }
}
