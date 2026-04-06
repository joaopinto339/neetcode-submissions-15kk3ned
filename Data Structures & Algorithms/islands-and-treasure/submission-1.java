class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        if (r == 0) return;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int dist) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || grid[r][c] == -1) {
            return;
        }

        if (dist > 0 && grid[r][c] <= dist) {
            return;
        }

        grid[r][c] = dist;

        dfs(grid, r + 1, c, dist + 1);
        dfs(grid, r - 1, c, dist + 1);
        dfs(grid, r, c + 1, dist + 1);
        dfs(grid, r, c - 1, dist + 1);
    }
}