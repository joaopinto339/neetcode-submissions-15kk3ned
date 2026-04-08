class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < ROWS; r++){
            if(board[r][0] == 'O'){
                q.add(new int[]{r,0});
            }
            if(board[r][COLS-1] == 'O'){
                q.add(new int[]{r,COLS-1});
            }
        }
        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O'){
                q.add(new int[]{0,c});
            }
            if(board[ROWS-1][c] == 'O'){
                q.add(new int[]{ROWS-1,c});
            }
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];
            board[r][c] = '#';

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS &&
                    board[nr][nc] == 'O'){
                    q.add(new int[]{nr,nc});
                }
            }
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                else if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }

    }
}
