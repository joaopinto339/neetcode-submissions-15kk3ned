class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(bfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c] = 0;

        int area = 1;

        while(!q.isEmpty()){
            int[] coor = q.poll();
            int row = coor[0], col = coor[1];

            for(int[] d : directions){
                int nr = row + d[0], nc = col + d[1];
                if(nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == 1){
                        area++;
                        q.offer(new int[]{nr,nc});
                        grid[nr][nc] = 0;
                    }
            }
        }
        return area;
    }
}
