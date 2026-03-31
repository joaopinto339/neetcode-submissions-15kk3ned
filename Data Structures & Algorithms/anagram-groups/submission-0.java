class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length < 2) 
            return List.of(List.of(strs[0]));

        HashMap<String, List<String>> res = new HashMap<String, List<String>>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            res.putIfAbsent(key, new ArrayList<String>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
