class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[length] = true;

        for(int i = length; i >= 0; i--){
            for(String word : wordDict){
                if(word.length() + i <= length && 
                    word.equals(s.substring(i, i + word.length()))){
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
        
    }
}
