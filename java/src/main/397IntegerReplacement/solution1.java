public class Solution {
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        else if( (n & 1) == 0){
            return 1 + integerReplacement(n >>> 1);
        }
        else if( n == 3 || ( (n&1)== 1 && (n& 2) == 0)){
            return 1 + integerReplacement(n-1);
        }
        else{
            return 1 + integerReplacement(n+1);
        }
    }
}
