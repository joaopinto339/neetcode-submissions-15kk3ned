class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mappedParentheses = new HashMap<>();
        mappedParentheses.put(')', '(');
        mappedParentheses.put(']', '[');
        mappedParentheses.put('}', '{');

        for(char c : s.toCharArray()){
            if(mappedParentheses.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == mappedParentheses.get(c)){
                    stack.pop();
                }
                else return false;
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
