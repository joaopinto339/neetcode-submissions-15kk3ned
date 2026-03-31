class Solution {
    int res = 0;
    public int uniquePaths(int m, int n) {
        dfs(m-1,n-1,0,0);
        return res;
    }

    private void dfs(int m, int n, int currR, int currC){
        if(currR > m || currC > n) return;      //out of bounds
        if(currR == m && currC == n) res++;

        dfs(m,n, currR+1, currC);
        dfs(m,n, currR, currC+1);
    }
}
