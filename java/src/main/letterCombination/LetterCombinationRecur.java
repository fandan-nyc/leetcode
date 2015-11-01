public class Solution {
    public List<String> letterCombinations(String digits) {
       
        return letterCombHepler(digits.toCharArray());
    }
    
    private List<String> letterCombHepler(char[] chars)
    {
        List<String> result = new ArrayList<String>();
        if(chars == null || chars.length == 0)
        {
            return result;
        }
        int number  = chars[0] - 48;
        char startChar = (char)getStartChar(number);
        int count = (number == 7 || number == 9) ? 4: 3;
        List<String> tmp = letterCombHepler(Arrays.copyOfRange(chars, 1 ,chars.length));
        if(tmp.size() == 0)
        {
            tmp.add("");
        }
        while(count > 0)
        {
            for(String i: tmp)
            {
            result.add((char)(startChar + count -1) + i);
            }
            count --;
        }
        return result;
    }
    
    
    private int getStartChar(int i)
    {
        if(i < 2)
        {
            throw new IllegalArgumentException("number should be no smaller than 2");
        }
        if(i < 8)
        {
            return 97 + (i-2) * 3;
        }
        else 
        {
            return 97 + (i-2) * 3 + 1;
        }
    }     
}
