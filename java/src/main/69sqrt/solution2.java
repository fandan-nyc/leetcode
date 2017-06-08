public class Solution {
    public int mySqrt(int x) {
       if(x == 0){
           return 0;
       }
       return helper(x, 1, Integer.MAX_VALUE);
    }
    
    private int helper(int x, int start, int end){
        int mid = start + ( end - start)/2;
        if(mid > x / mid){
            return helper(x, start, mid -1);
        }else{
            if((mid +1) > x / (mid+1)){
                return mid; 
            }else{
                return helper(x, mid+1, end);
            }
        }
    }
}
