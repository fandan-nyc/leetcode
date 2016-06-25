public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 || s.length() > 12){
            return result;
        }
        helper(result, s, "", 0);
        return result;
    }
    
    private void helper(List<String> result, String input, String tmp, int counter){
        if(counter == 4 && input.length() == 0){
            result.add(tmp.substring(1));
            return ;
        }
        int tmpNum = 0;
        for(int i = 0; i < 3 && i < input.length(); i++){
            tmpNum = tmpNum * 10 + input.charAt(i) - '0';
            if(tmpNum == 0){
                helper( result, input.substring(i+1), tmp+"."+tmpNum, counter+1); 
                break;
            }
            if(tmpNum <= 255){
                helper( result, input.substring(i+1), tmp+"."+tmpNum, counter+1); 
            }
        }
    }
}
