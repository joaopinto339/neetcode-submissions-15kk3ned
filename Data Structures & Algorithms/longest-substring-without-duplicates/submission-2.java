class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1) return s.length();
        int counter = 1;
        Set<Character> foundCharacters = new HashSet<>();
        int l = 0, r = 1;
        foundCharacters.add(s.charAt(l));
        while(r < s.length()){
            if(foundCharacters.contains(s.charAt(r))){
                foundCharacters = new HashSet<>();
                l++;
                r = l + 1;
                foundCharacters.add(s.charAt(l));
            }
            else{
                foundCharacters.add(s.charAt(r));
                counter = Math.max(foundCharacters.size(), counter);
                r++;
            }
        }
        return counter;
    }
}
