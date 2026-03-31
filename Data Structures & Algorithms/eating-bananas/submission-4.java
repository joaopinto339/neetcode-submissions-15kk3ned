class Solution {
    public int minEatingSpeed(int[] piles, int h) {      
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int k = r;
        
        while(l <= r){
            int hours = 0;
            int m = (l + r) / 2;
            for(int p : piles){
                hours += (p / m);
                if(p % m > 0) hours += 1; 
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
