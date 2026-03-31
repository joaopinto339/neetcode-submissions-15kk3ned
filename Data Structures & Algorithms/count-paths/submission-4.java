class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(m,n,0,0);
    }

    private int dfs(int m, int n, int currR, int currC){
        if(currR == (m-1) && currC == (n-1)) return 1;
        if(currR >= m || currC >= n) return 0;      //out of bounds

        if(memo[currR][currC] != -1){
            return memo[currR][currC];
        }

        return memo[currR][currC] = dfs(m,n, currR+1, currC) + 
            dfs(m,n, currR, currC+1);
    }
}
