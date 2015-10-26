public class Solution {
    public int uniquePaths(int m, int n) {
        int[] result = new int[n];
        for(int i = 0; i < n;i++)
        {
            result[i] = 1;
        }
        while(m -- > 1)
        {
            for(int i = 1; i < n;i++)
            {
                result[i] = result[i] + result[i-1];
            }
        }
        return result[n-1];
        
    }
}
