class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< A.length; i++){
            max = Math.max(max, sum(A, i));
        }
        return max;
    }
    
    private int sum(int[] A, int start){
        int sum = 0;
        int counter = 0;
        for(int i = start; i < start + A.length; i++){
            sum += (counter * A[i%A.length]);
            counter++;
        }
        return sum;
    }
}
