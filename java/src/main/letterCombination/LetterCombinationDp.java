
public class Solution {
    public List<String> letterCombinations(String digits) {
       
    char[] chars = digits.toCharArray());
    List<String> result = new ArrayList<String>();
    if(chars == null || chars.length == 0)
    {
        return result;
    }
    for(char k: chars)
    {
        char startChar = (char)getStartChar(k-48);
        int count = (number == 7 || number == 9) ? 4: 3;
        List<String> tmp = new ArrayList<String>();
        if(result.size() == 0)
        {
            result.add("");
        }
        while(count > 0)
        {
            for(String i: result)
            {
                tmp.add( i + (char)(startChar + count -1));
            }
            count --;
        }
            result = tmp ; 
    }
    return result;
}
    
    private int getStartChar(int i)
    {
        if(i < 2)
        {
            throw new IllegalArgumentException("number should be no smaller than 2");
        }
        return 97 + (i-2) * 3 + ((i < 8) ? 0 : 1);
    }
}
