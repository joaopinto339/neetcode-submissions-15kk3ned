class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fruits = 0;
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fruits++;
                }
            }
        }

        while(fruits > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] node = q.poll();
                int r = node[0], c = node[1];
                for(int[] dir : directions){
                    int row = dir[0] + r;
                    int col = dir[1] + c;

                    if(row < m && row >= 0 && col < n && col >= 0 &&
                        grid[row][col] == 1){
                            grid[row][col] = 2;
                            q.add(new int[]{row,col});
                            fruits--;
                    }        
                }
            }
            time++;
        }

        return fruits == 0 ? time : -1;
    }
}
