class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i]; 
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        Stack <Double> stack = new Stack<>();

        for(int[] n : cars){
            double timeUnit = (double) (target - n[0]) / n[1];
            stack.push(timeUnit);
            if(stack.size() > 1 && timeUnit <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
