public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 || b.length() == 0){
            return b;
        }
        int carryOver  = 0; 
        int aLen = a.length(); 
        int bLen = b.length();
        int aValue = 0 ;
        int bValue = 0;
        String result = "";
        while(carryOver == 1 || aLen > 0 || bLen > 0){
            aValue = 0 ;
            if(aLen > 0){
                aValue = a.charAt(aLen-1) - '0';
            }
            bValue  = 0;
            if(bLen > 0){
                bValue = b.charAt(bLen-1) - '0';
            }
            int tmp = carryOver + aValue + bValue;
            carryOver = tmp /2 ; 
            result  = (tmp %2) + result;
            aLen--; 
            bLen--;
        }
        return result ;
    }
}
