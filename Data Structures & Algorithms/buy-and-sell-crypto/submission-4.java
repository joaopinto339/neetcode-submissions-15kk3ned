class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int b = 0, s = 1; s < prices.length; ){
            if(prices[s] < prices[b]){
                b = s;
                s++;
            }
            else{
                res = Math.max(prices[s] - prices[b], res);
                s++;
            }
        }
        return res;
    }
}
