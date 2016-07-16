public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>(); 
        if(digits == null || digits.length() == 0){
            return result;
        }
        backtracking(result, new StringBuilder(), digits.toCharArray(), 0);
        return result;
    }
    
    private void backtracking(List<String> result, StringBuilder sb, char[] digits, int start){
        if(start == digits.length){
            result.add(new String(sb));
            return ; 
        }
        List<Character> curr = intToCharList(digits[start]);
        for(char i: curr){
            sb.append(i);
            backtracking(result, sb, digits, start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    private List<Character> intToCharList( char  input){
        List<Character> result = new ArrayList<Character>();
        if(input < '2' || input > '9'){
            return result;
        }
        char start = 'a';
        int total = 3;
        start = (char)(start + (input - '2') * 3);
        if(input >='8' && input <= '9'){
            start += 1;
        }
        if(input == '7' || input == '9'){
            total = 4;
        }
        for(int i = 0; i < total; i++){
            result.add(start);
            start++;
        }
        return result;
    }
}
