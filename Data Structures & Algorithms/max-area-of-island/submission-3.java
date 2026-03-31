class Solution {
    private final int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
    
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
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c] = 0;

        while(!q.isEmpty()){
            int[] coor = q.poll();
            for(int[] d : directions){
                int nr = coor[0] + d[0], nc = coor[1] + d[1];
                if(nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == 1){
                        q.offer(new int[]{nr,nc});
                        grid[nr][nc] = 0;
                        area++;
                    }
            }
        }
        return area;
    }
}
