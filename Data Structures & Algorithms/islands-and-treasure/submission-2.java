class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.size() == 0) return;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0], col = pos[1];

            for(int[] dir : directions){
                int r = dir[0] + row;
                int c = dir[1] + col;
                if(r >= rows || r < 0 || c >= cols || c < 0 || grid[r][c] != INF){
                    continue;
                }
                q.add(new int[]{r,c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
