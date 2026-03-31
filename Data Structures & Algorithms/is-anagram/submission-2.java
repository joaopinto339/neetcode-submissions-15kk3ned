class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> s1 = new HashMap<Character,Integer>();
        HashMap<Character,Integer> s2 = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = s1.getOrDefault(c, 0);
            s1.put(c, count+1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int count = s2.getOrDefault(c, 0);
            s2.put(c, count+1);
        }
        for(Character c : s1.keySet()){
            if(!s1.get(c).equals(s2.get(c))) return false;
        }
        return true;
    }
}
