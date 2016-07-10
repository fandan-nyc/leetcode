public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){
            return false;
        }
        return isAdditiveNumberHelper(num);
        
    }
    
    private boolean isAdditiveNumberHelper(String num){
       for(int i = 0; i <= num.length()/2;i++){
           if(num.charAt(0) == '0' && i != 0){
               break;
           }
           long first = Long.parseLong(num.substring(0, i+1));
           for(int j = i+1; j <= i+1 +(num.length()-i-1)/2; j++){
               if(num.charAt(i+1) == '0' && j != i+1){
                    break;
               }
               long second = Long.parseLong(num.substring(i+1, j+1));
               if(j+1== num.length()){
                    continue;
               }else{
                   boolean result = helper(num, first, second, j+1);
                   if(result){
                       return true;
                   }
               }
           }
       }
       return false;
    }
       
       private boolean helper(String num, long first, long second, int startPos){
           if(startPos >= num.length()){
               return true;
           }
           long total = first + second; 
           int size = (int)Math.log10(total);
           if(num.charAt(startPos) == '0' && total != 0){
               return false;
           }
           int nextPos = startPos+size+1;
           nextPos =nextPos >= num.length() ? num.length(): nextPos;
           long realTotal = Long.parseLong(num.substring(startPos, nextPos));
           if(realTotal != total){
               return false;
           }else{
               return helper(num, second, realTotal, nextPos);
           }
        }
}
