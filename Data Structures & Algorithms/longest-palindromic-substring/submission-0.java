class Solution {
    String res = "";
    int resLen = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            checkPalindrome(i, i, s);
            checkPalindrome(i, i+1, s);
        }
        return res;
    }

    private void checkPalindrome(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > resLen){
                resLen = r - l + 1;
                res = s.substring(l,r+1);
            }
            l--;
            r++;
        }
    }
}
