public class Solution {
    public String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();
        while(n != 0)
        {
            int i = n % 26 ; 
            char input = (i == 0) ? 'Z': (char)('A'+i-1);
            result.insert(0, input);
            if(i == 0)
            {
                n = n-26;
            }
            n = n/26;
        }
        return result.toString();
    }
}
