class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowFreq = new HashMap<>();
        int maxSize = Integer.MAX_VALUE;
        int[] minIndexes = new int[2];
        int need = tFreq.size();
        int have = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            windowFreq.put(curr, windowFreq.getOrDefault(curr,0) + 1);
            if(tFreq.containsKey(curr) && tFreq.get(curr).equals(windowFreq.get(curr))){
                have++;
            }
            while(need == have){
                if((r - l + 1) < maxSize){
                        minIndexes[0] = l;
                        minIndexes[1] = r;
                        maxSize = r - l + 1;
                }
                char leftChar = s.charAt(l);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if(tFreq.containsKey(leftChar) && tFreq.get(leftChar) >  windowFreq.get(leftChar)){
                    have--;
                }
                l++;   
            }
        }
        return maxSize == Integer.MAX_VALUE 
            ? "" 
            : s.substring(minIndexes[0], minIndexes[1] + 1);
    }
}
