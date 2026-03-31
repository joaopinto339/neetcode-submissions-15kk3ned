class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while(top <= bot){
            int row = (top + bot) / 2;
            if(target > matrix[row][COLS - 1]){
                top = row + 1;
            } else if(target < matrix[row][0]){
                bot = row - 1;
            } else {
                break;
            }
        }
        if(!(top <= bot)) return false;

        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(matrix[row][m] == target) return true;
            else if(matrix[row][m] > target){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return false;
    }
}
