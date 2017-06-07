public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pos = -1; 
        for(int i = 0; i < abbr.length(); i++){
            char curr = abbr.charAt(i);
            if(curr <= '0' || curr > '9'){
                // the case a, 01 will fail
                // you cannot have a number starting with 0
                pos++;
                if(pos >= word.length() || curr != word.charAt(pos)){
                   return false;
                }
           }else{
               int len = 0;
               while( i < abbr.length() && abbr.charAt(i) >='0' && abbr.charAt(i) <='9'){
                    i++;
                    len++;
               }
               pos += Integer.valueOf(abbr.substring( i-len,i));
               i--;
           }
        }
        return pos == word.length()-1;
    }
}
