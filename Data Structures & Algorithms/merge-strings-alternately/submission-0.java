class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int one = 0, two = 0;
        while(one < word1.length() || two < word2.length()){
            if(one < word1.length()){
                res += word1.charAt(one);
                one++;
            }
            if(two < word2.length()){
                res += word2.charAt(two);
                two++;
            }
        }
        return res;
    }
}