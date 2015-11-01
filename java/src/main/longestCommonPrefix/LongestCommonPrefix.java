public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs == null || strs.length == 0)
        {
            return result;
        }
        if( strs.length == 1)
        {
            return strs[0];
        }
        String tmp =  strs[0];
        for(int i = 0; i < tmp.length(); i++)
        {
            for(String j: strs)
            {
                if(i > j.length()-1)
                {
                    return  result;
                }
                else if (j.charAt(i) != tmp.charAt(i))
                {
                    return result ;
                }
            }
            result += ( "" + tmp.charAt(i));
        }
        return result;
    }
}
