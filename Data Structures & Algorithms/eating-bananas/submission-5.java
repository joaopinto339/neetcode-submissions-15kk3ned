class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int k = r;

        while(l <= r){
            int m = (r + l) / 2;
            int hours = 0;
            for(int p : piles){
                hours += p / m;
                if(p % m > 0) hours++;
            }
            if(hours <= h){
                k = m;
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return k;
    }
}
