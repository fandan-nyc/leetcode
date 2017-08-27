class Solution {
    public int getMoneyAmount(int n) {
      return helper(1, n);
    }
    
    private int helper(int start, int end){
        if( start >= end){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            res = Math.min(res, i + Math.max(helper(start, i-1), helper(i+1, end)));
        }
        return res;
    }
}
