class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            for(int j = i+1; j < heights.length; j++){
                int height = Math.min(heights[i], heights[j]);
                int area = height * (j-i);
                if(area > res){
                    res = area;
                }
            }
        }
        return res;
    }
}
