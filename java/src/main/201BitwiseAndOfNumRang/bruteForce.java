public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       // brute force
      if(m == n){
          return m;
      }
      int result = m & n;
      for(int i = m+1; i <= n;i++){
          result &= i;
      }
      return result;
    }
}
