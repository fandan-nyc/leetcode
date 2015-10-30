public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> happySet = new HashSet<Integer>();
        while(n != 1)
        {
            int tmp = 0;
            while(n != 0)
            {
                tmp += ( n%10) * (n%10);
                n /= 10;
            }
            n = tmp;
            if(happySet.contains(n))
            {
                return false;
            }
            else 
            {
                happySet.add(n);
            }
        }
        return true;
        
    }
}
