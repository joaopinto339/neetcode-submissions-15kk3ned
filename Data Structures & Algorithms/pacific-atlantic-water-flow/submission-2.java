class Solution {
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length; 
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COLS-1, atl, heights);
        }
        for(int c = 0; c < COLS; c++){
            dfs(0, c, pac, heights);
            dfs(ROWS-1, c, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !ocean[nr][nc] &&
                heights[nr][nc] >= heights[r][c]){
                    dfs(nr, nc, ocean, heights);
                }
        }
    }
}
