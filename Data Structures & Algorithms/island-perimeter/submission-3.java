class Solution {
    private int[][] grid;
    boolean [][] visited;
    int rows, cols;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    return dfs(r,c);
                }
            }
        }
        return 0;
    }

    private int dfs(int r, int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0){
            return 1;
        }
        if(visited[r][c]) return 0;

        visited[r][c] = true;
        return dfs(r+1,c) + dfs(r-1,c) 
            + dfs(r,c+1) + dfs(r,c-1);
    }
}