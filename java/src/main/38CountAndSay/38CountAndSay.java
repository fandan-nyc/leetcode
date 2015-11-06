public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        while(n > 1)
        {
            result = next(result);
            n --;
        }
        return result;
    }
    
    private String next(String i)
    {
        char tmp;
        int count = 0;
        String result = "";
        for(int k = 0;k < i.length();)
        {
            tmp = i.charAt(k);
            while(k < i.length() &&  i.charAt(k) == tmp)
            {
                count +=1;
                k++;
            }
            result = result + (Integer.toString(count) + tmp)  ;
            count = 0;
        }
        return result ; 
    }
}
