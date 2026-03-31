class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1) return "";
        String res = strs[0];

        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < res.length(); j++){
                if(j >= strs[i].length() || res.charAt(j) != strs[i].charAt(j)){
                    res = strs[i].substring(0,j);
                    break;
                }
                if(j >= strs[i].length()){
                    res = strs[i].substring(0,j);
                    break;
                }
            }
            if(res.length() < 1){
                break;
            }
        }
        return res;
    }
}