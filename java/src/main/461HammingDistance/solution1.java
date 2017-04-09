public class Solution {
    public int hammingDistance(int x, int y) {
       int tmp = x ^ y;
       int counter = 0 ; 
       while( tmp > 0) {
           tmp = tmp & (tmp-1);
           counter++;
       }
       return counter;
    }
}
