public class Solution {
    public List<String> letterCombinations(String digits) {
        
        if(digits == null || digits.length() == 0)
            return new ArrayList();
        List<String> result = convertNumberToAlpha(digits.charAt(0));
        for(int i = 1; i < digits.length();i++)
        {
            result = letterCombinationsHelper(result, digits.charAt(i));
        }
        return result ;
        
    }
    
    private List<String> letterCombinationsHelper(List<String> input, char i)
    {
        List<String> alphas = convertNumberToAlpha(i);
        List<String> result = new ArrayList<String>();
        for(String k: alphas){
            for(String j: input)
                result.add(j + k);
        }
        return result;
    }
    
    private List<String> convertNumberToAlpha(char i)
    {
        char start = (char)((i-'2') *3 + 'a');
        if(i > '7')
            start++;
        if(i < '7' || i == '8')
            return Arrays.asList(""+start, ""+(char)(start+1), ""+(char)(start+2));
        else
            return Arrays.asList(""+start, ""+(char)(start+1), ""+(char)(start+2), ""+(char)(start+3));
    }
    
}
