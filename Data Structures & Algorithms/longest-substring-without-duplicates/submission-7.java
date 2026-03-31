class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int l = 0, r = 0;
        Set<Character> chars = new HashSet<>();

        while(r < s.length()){
            while(chars.contains(s.charAt(r))){
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
