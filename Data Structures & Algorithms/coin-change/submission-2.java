class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i < amount + 1; i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;

        for(int i = 1; i < amount + 1; i++){
            for(int c = 0; c < coins.length; c++){
                if(i - coins[c] >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i- coins[c]]);
                }
            }
        }
        return dp[amount] != amount +1 ? dp[amount] : -1;
    }
}
