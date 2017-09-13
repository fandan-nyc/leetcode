
class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int arrSum = sum(A);
        int max = func(A);
        int res = max;
        for(int i = 0; i < A.length; i++){
            max = max - arrSum + A.length * A[i];
            res = Math.max(res, max);
        }
        return res;
        
    }
    
    private int sum(int[] A){
        int sum = 0;
        for(int i: A){
            sum += i;
        }
        return sum;
    }
    
    private int func(int[] A){
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += (i* A[i]);
        }
        return sum;
    }
}
