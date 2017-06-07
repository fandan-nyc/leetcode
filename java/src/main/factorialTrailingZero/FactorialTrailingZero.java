public class Solution {
    public int trailingZeroes(int n) {
        // for example, 100, we have 100/5 = 20. every 20 numbers, we have x = 5*k;
        // 100/25 = 4; there are4 numbers who are the k*25
        // the total number of 5s we have are 
        // 100/5 + 100/25 + 100/125 .... 
        int count  = 0; 
        while(n/5  !=0)
        {
            count += n / 5; 
            n =  n/ 5;
        }
        return count;
    }
}
