class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            int max = 0;
            while(!stack.isEmpty() && 
                temperatures[stack.peek()] < temperatures[i]){
                    int idx = stack.pop();
                    res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
