class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,Integer> incomingTrustee = new HashMap<>();
        Map<Integer,Integer> trusting = new HashMap<>();

        for(int i = 1; i <= n; i++){
            incomingTrustee.put(i,0);
            trusting.put(i,0);
        }

        for(int i = 0; i < trust.length; i++){
            int citizen = trust[i][0];
            int trustedCitizen = trust[i][1];
            trusting.put(citizen, trusting.get(citizen)+1);
            incomingTrustee.put(trustedCitizen, incomingTrustee.get(trustedCitizen)+1);
        }

        int res = -1;
        for(int i = 1; i <= n; i++){
            if(trusting.get(i) == 0 && incomingTrustee.get(i) == n -1){
                if(res != -1) return -1;
                res = i;
            }
        }
        return res;
    
    }
}