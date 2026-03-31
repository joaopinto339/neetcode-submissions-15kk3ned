class Solution {
    public boolean isValid(String s) {
        Stack<Character> openParentheses = new Stack<>();
        Map<Character, Character> mappedParentheses = new HashMap<>();
        mappedParentheses.put(')', '(');
        mappedParentheses.put(']', '[');
        mappedParentheses.put('}', '{');

        for(char c : s.toCharArray()){
            if(mappedParentheses.containsKey(c)){
                if(!openParentheses.isEmpty() && mappedParentheses.get(c) == openParentheses.peek()){
                    openParentheses.pop();
                }
                else return false;
            }
            else{
                openParentheses.push(c);
            }
        }
        return openParentheses.isEmpty();
    }
}
