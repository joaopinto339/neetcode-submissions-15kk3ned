class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int stringLen = s.length();
        boolean[] dp = new boolean[stringLen + 1];
        dp[stringLen] = true;

        for(int i = stringLen - 1; i >= 0; i--){
            for(String word : wordDict){
                int wordLen = word.length();
                if(i + wordLen <= stringLen &&
                    word.equals(s.substring(i, i + wordLen))){
                        dp[i] = dp[i + wordLen];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
