class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //if(k >= arr.length) return arr;
        int l = 0;
        int r = k-1;
        while(r < arr.length){
            if(r+1 < arr.length && (
                Math.abs(arr[r+1] - x) < Math.abs(arr[l] - x) || arr[r+1] == arr[r])){
                r++;
                l++;
            }else{
                break;
            }  
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = l; i <= r; i++){
            res.add(arr[i]);
        }
        return res;
    }
}