public class Solution {
    public int uniquePaths(int m, int n) {
        if(m ==1 && n ==1)
        {
            return 1;
        }
        long result = 1;
        for(int i=m,j=1;i <= m+n-2;i++,j++)
        {
            result *= i;
            result /= j;
        }
        return (int)result;
    }
}
